package com.example.habiboo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.example.habiboo.presentation.navigation.AppNavHost
import com.example.habiboo.presentation.screens.homescreen.HomeScreen
import com.example.habiboo.presentation.screens.homescreen.HomeScreenViewModel
import com.example.habiboo.presentation.theme.HabiBooTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val homeScreenViewModel by viewModels<HomeScreenViewModel> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HabiBooTheme {
                AppNavHost(navController = rememberNavController())
            }
        }
    }
}
