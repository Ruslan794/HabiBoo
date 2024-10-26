package com.example.habiboo.presentation.navigation

import CreateRoomScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.habiboo.presentation.screens.commentsscreen.CommentsScreen
import androidx.navigation.navArgument
import com.example.habiboo.presentation.screens.profilescreen.ProfileScreen
import com.example.habiboo.presentation.screens.roomScreen.RoomScreen
import com.example.habiboo.presentation.screens.addhabitscreen.AddHabitScreen
import com.example.habiboo.presentation.screens.communityscreen.CommunityScreen
import com.example.habiboo.presentation.screens.homescreen.HomeScreen
import com.example.habiboo.presentation.screens.loginscreen.LoginScreen
import com.example.habiboo.presentation.screens.loginscreen.SplashScreen
import java.net.URLDecoder

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
        composable(
            route = "room/{roomId}/{roomName}",
            arguments = listOf(
                navArgument("roomId") { type = NavType.StringType },
                navArgument("roomName") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val roomId = backStackEntry.arguments?.getString("roomId")
            val encodedRoomName = backStackEntry.arguments?.getString("roomName")
            val roomName = encodedRoomName?.let { URLDecoder.decode(it, "UTF-8") } ?: ""

            if (roomId != null) {
                RoomScreen(navController = navController, roomId = roomId, roomName = roomName)
            } else {
                // Обработка ошибки, если roomId равен null
            }
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
//        composable(NavDestination.Room.route) {
//            RoomScreen(navController)
//        }
        composable(NavDestination.Comments.route) {
            CommentsScreen(navController)
        }
        composable(NavDestination.CreateRoom.route) {
            CreateRoomScreen(navController)
        }
        composable(NavDestination.Profile.route) {
            ProfileScreen(navController)
        }
    }
}