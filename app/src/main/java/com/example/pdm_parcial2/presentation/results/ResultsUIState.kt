package com.example.pdm_parcial2.presentation.results

import com.example.pdm_parcial2.domain.model.Place

sealed class ResultsUiState {
    object Loading : ResultsUiState()
    data class Success(val places: List<Place>) : ResultsUiState()
    data class Error(val message: String) : ResultsUiState()
}