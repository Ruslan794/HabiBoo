package com.example.habiboo.presentation.screens.loginscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavHostController
import com.example.habiboo.R
import com.example.habiboo.presentation.navigation.NavDestination
import com.example.habiboo.presentation.theme.SulphurPoint
import com.example.habiboo.presentation.theme.mainBlack
import com.example.habiboo.presentation.theme.mainTextStyleMin
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavHostController, vm: LoginScreenViewModel = hiltViewModel()) {
    // Observe the LiveData
    val isUserLoggedIn = vm.isUserLoggedIn.observeAsState()

    LaunchedEffect(isUserLoggedIn.value) {
        delay(2000)
        when (isUserLoggedIn.value) {
            true -> {
                navController.navigate(NavDestination.Home.route) {
                    popUpTo(navController.graph.startDestinationId) {
                        inclusive = true
                    }
                }
            }
            false -> {
                navController.navigate(NavDestination.Login.route) {
                    popUpTo(navController.graph.startDestinationId) {
                        inclusive = true
                    }
                }
            }
            null -> {
                // Keep showing splash screen
            }
        }
    }

    // UI for the splash screen
    SplashScreenContent()
}
@Composable
fun SplashScreenContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.gradient_background),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
        ) {
            Text(
                text = "HabiBoo", style = TextStyle(
                    fontFamily = SulphurPoint,
                    fontWeight = FontWeight.Bold,
                    fontSize = 42.sp,
                    color = mainBlack
                )
            )

        }
    }
}
