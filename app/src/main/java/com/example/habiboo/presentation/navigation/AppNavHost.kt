package com.example.habiboo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.habiboo.presentation.screens.commentsscreen.CommentsScreen
import com.example.habiboo.presentation.screens.RoomScreen.RoomScreen
import com.example.habiboo.presentation.screens.addhabitscreen.AddHabitScreen
import com.example.habiboo.presentation.screens.communityscreen.CommunityScreen
import com.example.habiboo.presentation.screens.homescreen.HomeScreen
import com.example.habiboo.presentation.screens.loginscreen.LoginScreen
import com.example.habiboo.presentation.screens.loginscreen.SplashScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String = NavDestination.Splash.route,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavDestination.Home.route) {
            HomeScreen(navController)
        }

        composable(NavDestination.AddHabit.route) {
            AddHabitScreen(navController)
        }

        composable(NavDestination.Login.route) {
            LoginScreen(navController)
        }
        composable(NavDestination.Splash.route) {
            SplashScreen(navController)
        }
        composable(NavDestination.Community.route) {
            CommunityScreen(navController)
        }
        composable(NavDestination.Room.route) {
            RoomScreen(navController)
        }
        composable(NavDestination.Comments.route) {
            CommentsScreen(navController)
        }
    }
}