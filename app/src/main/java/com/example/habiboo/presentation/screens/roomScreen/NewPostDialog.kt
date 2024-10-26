package com.example.habiboo.presentation.screens.roomScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.habiboo.R
import com.example.habiboo.presentation.theme.backgroundWhite
import com.example.habiboo.presentation.theme.mainPurple
import com.example.habiboo.presentation.theme.mainTextStyleMin

@Composable
fun NewPostDialog(
    showDialog: Boolean = true,
    onClose: () -> Unit = {},
    onJoinClick: (String) -> Unit = {}
) {
    val fontSize = 15.sp

    if (showDialog) {
        Dialog(onDismissRequest = onClose) {
            Card(
                shape = RoundedCornerShape(15.dp),
                backgroundColor = Color.White
            ) {
                Box {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(18.dp)
                    ) {
                        Spacer(modifier = Modifier.height(36.dp))

                        Text(
                            text = "Create Post",
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 28.sp,
                            style = mainTextStyleMin,
                            fontWeight = FontWeight.Normal,
                            color = mainPurple,
                            textAlign = TextAlign.Center,
                        )

                        Spacer(Modifier.height(16.dp))



                        Box(
                            modifier = Modifier
                                .padding(horizontal = 100.dp)
                                .fillMaxWidth()
                                .height(100.dp)
                                .background(backgroundWhite)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.no_image),
                                contentDescription = "Background Image",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                                    .clip(RoundedCornerShape(16.dp)),
                                contentScale = ContentScale.Crop
                            )

                            //  AsyncImage(
                            //      model = ImageRequest.Builder(LocalContext.current)
                            //          .data("http://40.67.243.239/uploads/Main_After_6488a7899c.jpg")
                            //          //    .data(room.imageUrl)
                            //          .crossfade(true)
                            //          .build(),
                            //      contentDescription = "",
                            //      modifier = Modifier
                            //          .fillMaxWidth()
                            //          .height(200.dp)
                            //          .clip(RoundedCornerShape(16.dp))
                            //      ,
                            //      contentScale = ContentScale.Crop
                            //  )

                            androidx.compose.material3.IconButton(
                                onClick = {
                                    // Handle the click action
                                },
                                modifier = Modifier
                                    .align(Alignment.BottomEnd)
                                    .size(36.dp)
                                    .shadow(4.dp, CircleShape)
                                    .background(Color.White, CircleShape)
                            ) {
                                androidx.compose.material3.Icon(
                                    Icons.Filled.Add,
                                    contentDescription = "Edit",
                                    tint = mainPurple
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Description:",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            style = mainTextStyleMin,
                            color = mainPurple,
                            modifier = Modifier.padding(top = 16.dp)
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        OutlinedTextField(
                            value = "",
                            onValueChange = { },
                            label = {
                                Text(
                                    "Share your progress...",
                                    style = mainTextStyleMin,
                                    color = Color.Gray,
                                )
                            },
                            singleLine = true,
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                            keyboardActions = KeyboardActions(
                                onDone = {
                                    // Handle the 'Done' action on the keyboard
                                }
                            )
                        )

                        Button(
                            onClick = {
                                onJoinClick("password")
                            },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = mainPurple,
                                contentColor = Color.White
                            ),
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 28.dp)
                                .clip(RoundedCornerShape(15.dp)),
                        ) {
                            Text(
                                "CREATE",
                                style = mainTextStyleMin,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                modifier = Modifier.padding(vertical = 4.dp, horizontal = 28.dp)
                            )
                        }
                    }
                    IconButton(
                        onClick = onClose,
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(top = 14.dp, start = 14.dp)
                            .size(25.dp)
                    ) {
                        Icon(Icons.Filled.Close, contentDescription = "Close", tint = Color.Black)
                    }
                }
            }
        }
    }
}

