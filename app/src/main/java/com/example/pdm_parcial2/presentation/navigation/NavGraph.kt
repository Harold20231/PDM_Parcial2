package com.example.pdm_parcial2.presentation.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rankeuca.presentation.results.ResultsScreen
import com.rankeuca.presentation.results.ResultsViewModel
import com.rankeuca.presentation.vote.VoteScreen
import com.rankeuca.presentation.vote.VoteViewModel

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