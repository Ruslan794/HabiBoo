package com.example.habiboo.presentation.navigation

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.habiboo.presentation.screens.addhabitscreen.AddHabitScreen
import com.example.habiboo.presentation.screens.homescreen.HomeScreen
import com.example.habiboo.presentation.screens.homescreen.HomeScreenViewModel

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String = NavDestination.Home.route,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavDestination.Home.route) {
            HomeScreen(navController)
        }

        composable(NavDestination.AddHabit.route){
            AddHabitScreen(navController)
        }
    }
}