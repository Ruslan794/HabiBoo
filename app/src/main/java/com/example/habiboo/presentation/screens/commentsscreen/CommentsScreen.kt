package com.example.habiboo.presentation.screens.commentsscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.habiboo.common.EmptyListPlaceHolder
import com.example.habiboo.presentation.navigation.BottomNavigationBar
import com.example.habiboo.presentation.theme.backgroundWhite
import com.example.habiboo.presentation.theme.mainPurple
import com.example.habiboo.presentation.theme.mainRose
import com.example.habiboo.presentation.theme.mainTextStyleMin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommentsScreen(navController: NavController) {

    val testCommentList = listOf(1, 2, 3)

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        },
        modifier = Modifier.background(backgroundWhite),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Comments",
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
                modifier = Modifier.background(Color.Transparent)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundWhite)
                .padding(paddingValues)
        ) {
            if (testCommentList.isEmpty()) {
                EmptyListPlaceHolder(modifier = Modifier.weight(1f))
            } else {
                testCommentList.let {

                    LazyColumn(
                        modifier = Modifier
                            .weight(9f)
                            .padding(horizontal = 20.dp)
                            .padding(top = 20.dp)
                    ) {
                        items(testCommentList) { post ->
                            // TODO() : Add as parameters object of Comment class
                            CommentCard()
                            Spacer(modifier = Modifier.size(15.dp))
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Box(modifier = Modifier.height(66.dp)) {
                CommentInputField()
            }

        }
    }
}

@Composable
fun CommentCard() {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = 4.dp,
        modifier = Modifier.fillMaxSize().padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("http://40.67.243.239/uploads/coin_41b97a9b89.png")
                        //    .data(room.imageUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = "Profile picture",
                    modifier = Modifier
                        .size(40.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.width(16.dp))
                Text(
                    "Peter Parker",
                    fontWeight = FontWeight.SemiBold,
                    style = mainTextStyleMin,
                    color = mainPurple,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                "Well, well, well, look who’s being all responsible! Nice job, kid. Just don’t forget, a strong body is important, but a sharp mind wins the game. Keep it up, and maybe someday you'll be half as cool as me.",
                style = mainTextStyleMin,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(16.dp))

        }
    }
}

@Composable
fun CommentInputField() {

    Row(
        modifier = Modifier.fillMaxSize()
            .padding(horizontal = 32.dp, vertical = 8.dp)
            .clip( RoundedCornerShape(16.dp))
            .background(mainPurple.copy(0.65f)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = { },
            placeholder = { Text("Write a comment...", fontSize = 14.sp, color = Color.White) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color.Transparent,
                cursorColor = Color.White,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Send),
            keyboardActions = KeyboardActions(onSend = {
                // Handle send action, like posting the comment
            }),
            singleLine = true,
            modifier = Modifier
        )

        IconButton(
            onClick = {
                // Handle the post action
            },
            modifier = Modifier.size(36.dp),
        ) {
            Icon(Icons.AutoMirrored.Filled.Send, contentDescription = "Post", tint = Color.White)
        }
    }
}