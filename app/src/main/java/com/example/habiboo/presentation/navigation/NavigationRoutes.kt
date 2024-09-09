package com.example.habiboo.presentation.navigation

enum class Screen {
    HOME,
    ADD_HABIT,
}

sealed class NavDestination(val route: String) {
    data object Home : NavDestination(Screen.HOME.name)
    data object AddHabit : NavDestination(Screen.ADD_HABIT.name)
}