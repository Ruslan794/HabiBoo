package com.example.habiboo.presentation.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState


data class NavigationItem(val route: String, val icon: ImageVector, val title: String)

val items = listOf(
    NavigationItem(NavDestination.Home.route, Icons.Filled.Home, "Home"),
    NavigationItem("search", Icons.Filled.Search, "Search"),
    NavigationItem("notifications", Icons.Filled.Notifications, "Notifications"),
    NavigationItem("profile", Icons.Filled.AccountCircle, "Profile")
)

@Composable
fun BottomNavigationBar(navController: NavController) {
    BottomNavigation {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = null) },
                label = { Text(item.title) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        // Avoid multiple copies of the same destination
                        launchSingleTop = true
                        // Restore state when revisiting a previously visited screen
                        restoreState = true
                    }
                }
            )
        }
    }
}