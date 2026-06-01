package com.example.pdm_parcial2.presentation.results


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pdm_parcial2.di.AppModule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ResultsViewModel : ViewModel() {
    private val repository = AppModule.placeRepository

    private val _uiState = MutableStateFlow<ResultsUiState>(ResultsUiState.Loading)
    val uiState: StateFlow<ResultsUiState> = _uiState

    init {
        loadResults()
    }

    fun loadResults() {
        viewModelScope.launch {
            _uiState.value = ResultsUiState.Loading
            try {
                val places = repository.getPlaces()
                    .sortedByDescending { it.votes }
                _uiState.value = ResultsUiState.Success(places)
            } catch (e: Exception) {
                _uiState.value = ResultsUiState.Error("Error al cargar resultados")
            }
        }
    }
}