package com.example.pdm_parcial2.presentation.navigation


import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pdm_parcial2.presentation.results.ResultsViewModel
import com.example.pdm_parcial2.presentation.results.ResultsScreen
import com.example.pdm_parcial2.screens.home.VoteScreen

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.Vote.route) {
        composable(Routes.Vote.route) {
            VoteScreen(
                viewModel = VoteViewModel(),
                onNavigateToResults = {
                    navController.navigate(Routes.Results.route)
                }
            )
        }
        composable(Routes.Results.route) {
            ResultsScreen(
                viewModel = ResultsViewModel(),
                onNavigateToVote = {
                    navController.popBackStack()
                }
            )
        }
    }
}

@Composable
fun VoteViewModel() {
    TODO("Not yet implemented")
}