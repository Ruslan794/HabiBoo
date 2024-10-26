package com.example.habiboo.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.habiboo.R
import com.example.habiboo.data.network.model.room.Room
import com.example.habiboo.domain.model.Habit
import com.example.habiboo.presentation.theme.PrimaryTextDark
import com.example.habiboo.presentation.theme.mainPurple
import com.example.habiboo.presentation.theme.mainTextStyleMin

@Composable
fun RoomCard(room: Room, onRoomClick: (String) -> Unit) {

    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onRoomClick(room.id) }
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Column(modifier = Modifier
                .fillMaxHeight()
                .padding(12.dp)
                .weight(3f)) {

                Text(
                    text = room.name,
                    style = mainTextStyleMin,
                    color = mainPurple,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )

                Row(
                    modifier = Modifier.padding(top = 12.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.community_icon),
                        contentDescription = "Background Image",
                        modifier = Modifier
                            .height(20.dp)
                            .width(20.dp),
                        contentScale = ContentScale.Fit
                    )
                    Text(
                        text = "${room.currentMembers}",
                        style = mainTextStyleMin,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )

                    Image(
                        painter = painterResource(id = if (room.close) R.drawable.lock_locked else R.drawable.lock_unlocked),
                        contentDescription = "Background Image",
                        modifier = Modifier
                            .height(20.dp)
                            .width(20.dp),
                        contentScale = ContentScale.Fit
                    )
                    Text(
                        text = if (room.close) "Private" else "Public",
                        fontSize = 16.sp,
                        style = mainTextStyleMin,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )

                }

                Spacer(modifier = Modifier.padding(top = 12.dp))
                Text(
                    text = "Read info",
                    style = mainTextStyleMin,
                    fontSize = 18.sp,
                    textDecoration = TextDecoration.Underline
                )
            }
            Spacer(modifier = Modifier.width(25.dp))

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(room.image)
                    //    .data(room.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = "Loaded Image",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 10.dp)
                    .weight(2f),
                contentScale = ContentScale.FillHeight
            )
        }
    }

}

