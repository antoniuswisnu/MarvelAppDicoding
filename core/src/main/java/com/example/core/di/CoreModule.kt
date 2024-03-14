package com.example.core.di

import androidx.room.Room
import com.example.core.data.MarvelRepository
import com.example.core.data.source.local.LocalDataSource
import com.example.core.data.source.local.room.MarvelDatabase
import com.example.core.data.source.remote.RemoteDataSource
import com.example.core.data.source.remote.network.ApiService
import com.example.core.domain.repository.IMarvelRepository
import com.example.core.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    factory { get<MarvelDatabase>().marvelDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            MarvelDatabase::class.java, "Marvel.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com:443/v1/public/characters?limit=10&apikey=fd460ee1092af59044da6d9750da01b4")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IMarvelRepository> {
        MarvelRepository(
            get(),
            get(),
            get()
        )
    }
}