package com.example.habiboo.presentation.navigation

enum class Screen {
    HOME,
    ADD_HABIT,
    LOGIN,
    SPlASH,
    COMMUNITY,
    ROOM,
    COMMENTS
}

sealed class NavDestination(val route: String) {
    data object Home : NavDestination(Screen.HOME.name)
    data object AddHabit : NavDestination(Screen.ADD_HABIT.name)
    data object Login: NavDestination(Screen.LOGIN.name)
    data object Splash: NavDestination(Screen.SPlASH.name)
    data object Community: NavDestination(Screen.COMMUNITY.name)
    data object Room: NavDestination(Screen.ROOM.name)
    data object Comments: NavDestination(Screen.COMMENTS.name)
}