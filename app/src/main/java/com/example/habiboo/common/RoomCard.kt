package com.example.habiboo.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.example.habiboo.domain.model.Habit
import com.example.habiboo.domain.model.Room
import com.example.habiboo.presentation.theme.PrimaryTextDark
import com.example.habiboo.presentation.theme.mainPurple
import com.example.habiboo.presentation.theme.mainTextStyleMin

@Composable
fun RoomCard(room: Room, onRoomClick: (String) -> Unit) {

    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
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
            Column {
                Text(
                    text = room.name,
                    style = mainTextStyleMin,
                    color = mainPurple,
                    fontWeight = FontWeight.Bold
                )

                Row {
                    Image(
                        painter = painterResource(id = R.drawable.login_screen_image),
                        contentDescription = "Background Image",
                        modifier = Modifier
                            .height(20.dp)
                            .width(20.dp),
                        contentScale = ContentScale.Fit
                    )
                    Text(
                        text = "${room.currentMembers}/${room.maxMembers}",
                        style = mainTextStyleMin,
                    )

                    Image(
                        painter = painterResource(id = R.drawable.login_screen_image),
                        contentDescription = "Background Image",
                        modifier = Modifier
                            .height(20.dp)
                            .width(20.dp),
                        contentScale = ContentScale.Fit
                    )
                    Text(
                        text = if (room.isPrivate) "Private" else "Public",
                        style = mainTextStyleMin,
                    )

                }

                Text(text = "Read info", style = mainTextStyleMin, textDecoration = TextDecoration.Underline)
            }

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(room.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = "Loaded Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }

}


@Composable
fun HabitCard(habit: Habit, onHabitClick: (String) -> Unit) {

    val image = if (habit.currentStreak < 3) R.drawable.poop_icon
    else R.drawable.fire_icon


    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onHabitClick(habit.id.toString()) }
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = habit.name,
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp),
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(48.dp)
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "Fire Icon",
                    modifier = Modifier.size(48.dp)
                )
                Text(
                    text = habit.currentStreak.toString(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryTextDark,
                    modifier = Modifier
                        .padding(top = 20.dp, start = 4.dp, end = 4.dp, bottom = 4.dp)
                )
            }
        }
    }
}
