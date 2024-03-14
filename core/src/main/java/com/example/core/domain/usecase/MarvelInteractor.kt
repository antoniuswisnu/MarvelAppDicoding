package com.example.core.domain.usecase

import com.example.core.domain.model.Marvel
import com.example.core.domain.repository.IMarvelRepository

class MarvelInteractor(private val marvelRepository: IMarvelRepository): MarvelUseCase {

    override fun getAllMarvel() = marvelRepository.getAllMarvel()

    override fun getFavoriteMarvel() = marvelRepository.getFavoriteMarvel()

    override fun setFavoriteMarvel(marvel: Marvel, state: Boolean) = marvelRepository.setFavoriteMarvel(marvel, state)
}