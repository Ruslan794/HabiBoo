package com.example.habiboo.presentation.navigation

enum class Screen {
    HOME,
    ADD_HABIT,
    LOGIN,
    SPlASH
}

sealed class NavDestination(val route: String) {
    data object Home : NavDestination(Screen.HOME.name)
    data object AddHabit : NavDestination(Screen.ADD_HABIT.name)
    data object Login: NavDestination(Screen.LOGIN.name)
    data object Splash: NavDestination(Screen.SPlASH.name)
}