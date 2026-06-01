package com.example.pdm_parcial2.data.api.dto

import kotlinx.serialization.Serializable

@Serializable
data class PlaceDto(
    val id: String,
    val name: String,
    val imageUrl: String,
    val votes: Int
)