package com.example.pdm_parcial2.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ui.components.ErrorView
import com.example.ui.components.LoadingView
import com.example.ui.components.PlaceCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VoteScreen(
    viewModel: VoteViewModel,
    onNavigateToResults: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Votar - ¿Dónde almorzamos?") }) },
        floatingActionButton = {
            if (uiState is VoteUiState.Success && (uiState as VoteUiState.Success).selectedPlaceId != null) {
                FloatingActionButton(onClick = onNavigateToResults) {
                    Text("Ir a resultados")
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            when (uiState) {
                is VoteUiState.Loading -> LoadingView()
                is VoteUiState.Error -> ErrorView((uiState as VoteUiState.Error).message) {
                    viewModel.loadPlaces()
                }
                is VoteUiState.Success -> {
                    val state = uiState as VoteUiState.Success
                    LazyColumn {
                        items(state.places.size) { index ->
                            val place = state.places[index]
                            PlaceCard(
                                place = place,
                                isSelected = place.id == state.selectedPlaceId,
                                onVote = { viewModel.vote(place.id) }
                            )
                        }
                    }
                }
            }
        }
    }
}