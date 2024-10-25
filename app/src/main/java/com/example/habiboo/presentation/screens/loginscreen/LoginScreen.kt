package com.example.habiboo.presentation.screens.loginscreen

import android.window.SplashScreen
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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.habiboo.R
import com.example.habiboo.presentation.navigation.NavDestination
import com.example.habiboo.presentation.theme.SulphurPoint
import com.example.habiboo.presentation.theme.mainBlack
import com.example.habiboo.presentation.theme.mainTextStyleMin


@Composable
fun LoginScreen(navController: NavHostController, vm: LoginScreenViewModel = viewModel()) {

    val isLoggedIn = vm.isUserLoggedIn.observeAsState(initial = false)

    SplashScreen()

    if (isLoggedIn.value)
        navController.navigate(NavDestination.Home.route)
    else
        LoginScreenContent(navController, vm)
}

@Composable
fun LoginScreenContent(navController: NavHostController, vm: LoginScreenViewModel) {
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

            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Email", style = mainTextStyleMin) },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Password", style = mainTextStyleMin) },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            TextButton(
                onClick = { /* Handle sign up */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text("Forgot Password?", style = mainTextStyleMin)
            }

            Button(
                onClick = { /* Handle sign in */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Text("Sign in")
            }
            TextButton(
                onClick = { /* Handle sign up */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sign up")
            }
        }
    }
}

@Composable
fun SplashScreen() {
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
