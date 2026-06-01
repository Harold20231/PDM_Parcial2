package com.example.pdm_parcial2.data.api.dto

import kotlinx.serialization.Serializable

@Serializable
data class VoteResponseDto(
    val success: Boolean,
    val message: String
)