package com.example.habiboo.presentation.screens.RoomScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.habiboo.R
import com.example.habiboo.common.EmptyListPlaceHolder
import com.example.habiboo.domain.model.Room
import com.example.habiboo.domain.model.Task
import com.example.habiboo.presentation.navigation.BottomNavigationBar
import com.example.habiboo.presentation.theme.backgroundWhite
import com.example.habiboo.presentation.theme.mainPurple
import com.example.habiboo.presentation.theme.mainTextStyleMin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoomScreen(navController: NavController) {

    var room = Room(
        id = "room1",
        name = "Room 1",
        description = "Description of Room 1 with detailed info.",
        maxMembers = 10,
        currentMembers = 1,
        isPrivate = false,
        imageUrl = "http://example.com/image$.jpg",
        tasks = listOf(
            Task(
                id = "task 1",
                name = "Task 1",
                description = "Task 1 description",
                isCompleted = false
            ),
        )
    )

    val testList = listOf(1, 2, 3, 4, 5)

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        },
        modifier = Modifier.background(backgroundWhite),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Weight Warriors",
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
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Handle FAB click action */ },
                backgroundColor = mainPurple
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    tint = Color.White
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundWhite)
                .padding(paddingValues)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.goal_icon),
                    contentDescription = "Bottom navigation Image",
                    modifier = Modifier.size(26.dp),
                )
                Spacer(Modifier.width(12.dp))
                Text(
                    "Goal:",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    style = mainTextStyleMin,
                    color = mainPurple,
                )
                Spacer(Modifier.width(12.dp))
                Text(
                    text = "Strength training and endurance building",
                    style = mainTextStyleMin,
                    fontSize = 16.sp,
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            WeekDaysRow()

            if (testList.isEmpty()) {
                EmptyListPlaceHolder(modifier = Modifier.weight(1f))
            } else {
                testList.let {

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 20.dp)
                            .padding(top = 20.dp)
                    ) {
                        items(testList) { post ->
                            // TODO() : Add as parameters object of Post class and onClick lamda
                            PostCard()
                            Spacer(modifier = Modifier.size(15.dp))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PostCard() {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = 4.dp,
        modifier = Modifier.padding(8.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.profile_icon),
                    contentDescription = "Profile picture",
                    modifier = Modifier.size(40.dp).clip(RoundedCornerShape(50)),
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.width(8.dp))
                Text("Peter Parker", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Outlined.Warning,
                    contentDescription = "Alert",
                    modifier = Modifier.size(24.dp)
                )
            }
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "Workout Image",
                modifier = Modifier.fillMaxWidth().height(200.dp),
                contentScale = ContentScale.Crop
            )
            Icon(
                imageVector = Icons.Filled.PlayArrow,
                contentDescription = "Play Video",
                modifier = Modifier.size(48.dp).align(Alignment.CenterHorizontally),
                tint = Color.White
            )
            Text(
                "Hello, guys! Finished my workout this morning!",
                modifier = Modifier.padding(8.dp),
                fontSize = 14.sp
            )
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.comment_dots),
                    contentDescription = "Background Image",
                    modifier = Modifier.size(20.dp),
                    contentScale = ContentScale.Fit
                )
                Text("10", modifier = Modifier.padding(start = 4.dp))
                Spacer(Modifier.width(16.dp))
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Likes",
                    tint = Color.Red
                )
                Text("4", modifier = Modifier.padding(start = 4.dp))
                Spacer(Modifier.width(16.dp))
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Shares",
                    tint = Color.Blue
                )
                Text("4", modifier = Modifier.padding(start = 4.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPostCard() {
    MaterialTheme {
        PostCard()
    }
}

@Composable
fun WeekDaysRow() {

    val days = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
    val dates = listOf(12, 13, 14, 15, 16, 17, 18)

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
    ) {
        items(days.zip(dates)) { (day, date) ->
            DayButton(day, date)
        }
    }
}

@Composable
fun DayButton(day: String, date: Int) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = 10.dp,
        backgroundColor = Color.White,
        modifier = Modifier
            .clickable { /* Handle click here */ }
            .width(70.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text(
                text = day,
                color = mainPurple,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "$date",
                color = mainPurple,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

