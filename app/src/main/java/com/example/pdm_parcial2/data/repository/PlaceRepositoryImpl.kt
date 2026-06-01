package com.example.pdm_parcial2.data.repository

import com.example.pdm_parcial2.data.api.RankeUcaApi
import com.example.pdm_parcial2.data.api.dto.mapper.toDomain
import com.example.pdm_parcial2.domain.model.Place
import com.example.pdm_parcial2.domain.repository.PlaceRepository

class PlaceRepositoryImpl(
    private val api: RankeUcaApi
) : PlaceRepository {
    override suspend fun getPlaces(): List<Place> {
        return api.getPlaces().map { it.toDomain() }
    }

    override suspend fun vote(placeId: String): Boolean {
        return api.vote(placeId)
    }
}