package com.example.core.domain.repository

import com.example.core.data.Resource
import com.example.core.domain.model.Marvel
import kotlinx.coroutines.flow.Flow

interface IMarvelRepository {
    fun getAllMarvel(): Flow<Resource<List<Marvel>>>
    fun getFavoriteMarvel(): Flow<List<Marvel>>
    fun setFavoriteMarvel(tourism: Marvel, state: Boolean)

}