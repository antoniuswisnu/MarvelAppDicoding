package com.example.core.utils

import com.example.core.data.source.local.entity.MarvelEntity
import com.example.core.data.source.remote.response.ResultsItem
import com.example.core.domain.model.Marvel

object DataMapper {
    fun mapResponsesToEntities(input: List<ResultsItem>): List<MarvelEntity> {
        val marvelList = ArrayList<MarvelEntity>()
        input.map {
            val marvel = MarvelEntity(
                id = it.id,
                name = it.name,
                description = it.description,
                thumbnail = it.thumbnail.path,
                isFavorite = false
            )
            marvelList.add(marvel)
        }
        return marvelList
    }

    fun mapEntitiesToDomain(input: List<MarvelEntity>): List<Marvel> =
        input.map {
            Marvel(
                id = it.id,
                name = it.name,
                description = it.description,
                thumbnail = it.thumbnail,
                isFavorite = false
            )
        }

    fun mapDomainToEntity(input: Marvel) = MarvelEntity(
        id = input.id,
        name = input.name,
        description = input.description,
        thumbnail = input.thumbnail,
        isFavorite = input.isFavorite
    )
}