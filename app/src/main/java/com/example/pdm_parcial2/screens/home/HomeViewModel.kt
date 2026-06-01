package com.example.pdm_parcial2.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pdm_parcial2.di.AppModule
import com.example.pdm_parcial2.domain.model.Place
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class VoteViewModel : ViewModel() {
    private val repository = AppModule.placeRepository

    private val _uiState = MutableStateFlow<VoteUiState>(VoteUiState.Loading)
    val uiState: StateFlow<VoteUiState> = _uiState

    private var places: List<Place> = emptyList()

    init {
        loadPlaces()
    }

    fun loadPlaces() {
        viewModelScope.launch {
            _uiState.value = VoteUiState.Loading
            try {
                places = repository.getPlaces()
                _uiState.value = VoteUiState.Success(places = places, selectedPlaceId = null)
            } catch (e: Exception) {
                _uiState.value = VoteUiState.Error("Error al cargar lugares")
            }
        }
    }

    fun vote(placeId: String) {
        viewModelScope.launch {
            val success = repository.vote(placeId)
            if (success) {
                val currentState = _uiState.value
                if (currentState is VoteUiState.Success) {
                    _uiState.value = currentState.copy(selectedPlaceId = placeId)
                }
            } else {
                _uiState.value = VoteUiState.Error("Error al votar")
            }
        }
    }
}