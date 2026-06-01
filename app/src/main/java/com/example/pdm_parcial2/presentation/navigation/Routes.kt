package com.example.pdm_parcial2.presentation.navigation

sealed class Routes(val route: String) {
    object Vote : Routes("vote")
    object Results : Routes("results")
}
