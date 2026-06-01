package com.example.pdm_parcial2.presentation.vote

import com.example.pdm_parcial2.domain.model.Place

sealed class VoteUiState {
    object Loading : VoteUiState()
    data class Success(val places: List<Place>, val selectedPlaceId: String?) : VoteUiState()
    data class Error(val message: String) : VoteUiState()
}