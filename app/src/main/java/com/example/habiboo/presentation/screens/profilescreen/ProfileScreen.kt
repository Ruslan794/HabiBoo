package com.example.habiboo.presentation.screens.profilescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.habiboo.presentation.navigation.BottomNavigationBar
import com.example.habiboo.presentation.theme.Poppins
import com.example.habiboo.presentation.theme.backgroundWhite
import com.example.habiboo.presentation.theme.mainPurple
import com.example.habiboo.presentation.theme.mainTextStyleMin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {

    var username by remember { mutableStateOf("*username*") }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        },
        modifier = Modifier.background(backgroundWhite),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Hallo, ${username}!",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 20.dp),
                        style = mainTextStyleMin,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp,
                        color = Color.Black
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                },
                modifier = Modifier.background(backgroundWhite),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White, // Background color
                    titleContentColor = Color.Black, // Title color
                    navigationIconContentColor = Color.Black // Navigation icon color
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
                .padding(16.dp)
        ) {

            Box(
                modifier = Modifier
                    .padding(horizontal = 100.dp)
                    .fillMaxWidth()
                    .height(125.dp),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("http://40.67.243.239/uploads/coin_0989ba3e55.png")
                        //    .data(room.imageUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = "Profile picture",
                    modifier = Modifier
                        .size(125.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            UserDataField(label = "Username:", data = "Peter Parker")
            UserDataField(label = "Telephone:", data = "+491557589498129")
            UserDataField(label = "Email:", data = "peter.parker@icloud.com")

            Spacer(modifier = Modifier.height(64.dp))


            Button(
                onClick = { /* Handle create room */ }, colors = ButtonDefaults.buttonColors(
                    containerColor = mainPurple
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 75.dp)
            ) {
                Text(
                    "EDIT",
                    style = mainTextStyleMin,
                    fontSize = 21.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

    }
}


@Composable
fun UserDataField(label: String, data: String) {
    Column {
        Text(
            text = label,
            color = mainPurple,
            style = mainTextStyleMin,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(4.dp))

        androidx.compose.material.OutlinedTextField(
            value = data,
            shape = RoundedCornerShape(25.dp),
            onValueChange = { },
            textStyle = TextStyle(fontSize = 18.sp, fontFamily = Poppins, fontWeight = FontWeight.Medium,),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color.Transparent,
                cursorColor = Color.White,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = mainPurple
            ),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Send),
            keyboardActions = KeyboardActions(onSend = {
                // Handle send action, like posting the comment
            }),
            singleLine = true,
            modifier = Modifier.fillMaxWidth())
    }
    Spacer(modifier = Modifier.height(16.dp))
}