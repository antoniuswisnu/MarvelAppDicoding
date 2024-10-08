package com.example.core.data.source.remote.network

import com.example.core.data.source.remote.response.Data
import retrofit2.http.GET

interface ApiService {
    @GET("list")
    suspend fun getList(): Data
}