package com.example.habiboo.presentation.screens.loginscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.habiboo.R
import com.example.habiboo.presentation.navigation.NavDestination
import com.example.habiboo.presentation.theme.SulphurPoint
import com.example.habiboo.presentation.theme.mainBlack
import com.example.habiboo.presentation.theme.mainPurple
import com.example.habiboo.presentation.theme.mainTextStyleMin
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.habiboo.presentation.theme.backgroundWhite

@Composable
fun LoginScreen(navController: NavHostController, vm: LoginScreenViewModel = hiltViewModel()) {

    val loginSuccess = vm.loginSuccess.observeAsState()

    LaunchedEffect(loginSuccess.value) {
        if (loginSuccess.value == true) {
            navController.navigate(NavDestination.Home.route) {
                popUpTo(navController.graph.startDestinationId) {
                    inclusive = true
                }
            }
        }
    }


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
                .padding(22.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.login_screen_image),
                contentDescription = "Background Image",
                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "HabiBoo", style = TextStyle(
                    fontFamily = SulphurPoint,
                    fontWeight = FontWeight.Bold,
                    fontSize = 42.sp,
                    color = mainBlack
                )
            )

            Spacer(modifier = Modifier.height(60.dp))

            Column(
                modifier = Modifier
                    .background(color = backgroundWhite, shape = RoundedCornerShape(10.dp))
                    .padding(horizontal = 15.dp, vertical = 25.dp)
            )
            {


                OutlinedTextField(
                    value = vm.email.value,
                    onValueChange = {
                        vm.setEmail(it)
                    },
                    label = { Text("Email", style = mainTextStyleMin) },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = vm.password.value,
                    onValueChange = {
                        vm.setPassword(it)
                    },
                    label = { Text("Password", style = mainTextStyleMin) },
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                TextButton(
                    onClick = { vm.onSingInBtnPress() },
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text("Forgot Password?", style = mainTextStyleMin)
                }

                Button(
                    onClick = { vm.onSingInBtnPress()},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = mainPurple
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text("Sign in", style = mainTextStyleMin, fontSize = 18.sp)
                }
                TextButton(
                    onClick = { /* Handle sign up */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Sign up", style = mainTextStyleMin, fontSize = 16.sp)
                }
            }

        }
    }
}
