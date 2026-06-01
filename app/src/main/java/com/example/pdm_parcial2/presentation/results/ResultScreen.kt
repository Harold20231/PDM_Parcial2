package com.example.pdm_parcial2.presentation.results



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pdm_parcial2.ui
import com.rankeuca.ui.components.ErrorView
import com.rankeuca.ui.components.LoadingView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultsScreen(
    viewModel: ResultsViewModel,
    onNavigateToVote: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    var isRefreshing by remember { mutableStateOf(false) }

    fun refresh() {
        isRefreshing = true
        viewModel.loadResults()
        isRefreshing = false
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Resultados") },
                actions = {
                    Button(onClick = onNavigateToVote) {
                        Text("Nuevo")
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            when (uiState) {
                is ResultsUiState.Loading -> LoadingView()
                is ResultsUiState.Error -> ErrorView((uiState as ResultsUiState.Error).message) {
                    viewModel.loadResults()
                }
                is ResultsUiState.Success -> {
                    val places = (uiState as ResultsUiState.Success).places
                    LazyColumn {
                        items(places.size) { index ->
                            val place = places[index]
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            ) {
                                Column(modifier = Modifier.padding(16.dp)) {
                                    Text(text = place.name, style = MaterialTheme.typography.titleLarge)
                                    Text(text = "Votos: ${place.votes}", style = MaterialTheme.typography.bodyMedium)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}