package com.example.pdm_parcial2.domain.repository

import com.example.pdm_parcial2.domain.model.Place

interface PlaceRepository {
    suspend fun getPlaces(): List<Place>
    suspend fun vote(placeId: String): Boolean
}

