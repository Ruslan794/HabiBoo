package com.example.habiboo.presentation.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.habiboo.R
import com.example.habiboo.presentation.theme.mainPurple
import com.example.habiboo.presentation.theme.mainTextStyleMin


data class NavigationItem(val route: String, val icon: Int, val title: String)

val items = listOf(
    NavigationItem(NavDestination.Home.route, R.drawable.home_icon, "Home"),
    NavigationItem(NavDestination.Community.route, R.drawable.comunity_icon, "Explore"),
    NavigationItem("", R.drawable.new_room_icon, "New room"),
    NavigationItem("", R.drawable.profile_icon, "Profile")
)

@Composable
fun BottomNavigationBar(navController: NavController) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {

        BottomNavigation(
            backgroundColor = Color.White,
            contentColor = Color.White,
            modifier = Modifier.height(80.dp)
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        Image(
                            painter = painterResource(item.icon),
                            contentDescription = "Bottom navigation Image",
                            modifier = Modifier
                                .height(40.dp)
                                .width(40.dp)
                                .padding(5.dp),
                            contentScale = ContentScale.Fit,
                            colorFilter = if (currentRoute == item.route) ColorFilter.tint(
                                mainPurple
                            )
                            else ColorFilter.tint(Color.Black)
                        )
                    },
                    label = {
                        Text(
                            item.title,
                            style = mainTextStyleMin,
                            fontSize = 14.sp,
                        )
                    },
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    selectedContentColor = mainPurple,
                    unselectedContentColor = Color.Black,
                    modifier = Modifier.padding(vertical = 6.dp),
                )
            }
        }
    }
}
