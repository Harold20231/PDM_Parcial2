package com.example.pdm_parcial2.di

import com.example.pdm_parcial2.data.api.RankeUcaApi
import com.example.pdm_parcial2.data.repository.PlaceRepositoryImpl
import com.example.pdm_parcial2.domain.repository.PlaceRepository

object AppModule {
    private val api = RankeUcaApi()
    val placeRepository: PlaceRepository = PlaceRepositoryImpl(api)
}
