package com.example.habiboo.presentation.screens.roomScreen

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.habiboo.R
import com.example.habiboo.common.EmptyListPlaceHolder
import com.example.habiboo.data.network.model.post.PostData
import com.example.habiboo.domain.model.Room
import com.example.habiboo.domain.model.Task
import com.example.habiboo.presentation.navigation.BottomNavigationBar
import com.example.habiboo.presentation.theme.backgroundWhite
import com.example.habiboo.presentation.theme.mainPurple
import com.example.habiboo.presentation.theme.mainTextStyleMin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoomScreen(
    navController: NavController,
    roomId: String,
    roomName: String,
    viewModel: RoomViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = roomId) {
        viewModel.fetchRoomPosts(roomId)
    }

    val posts by viewModel.posts.observeAsState(emptyList())

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
                        roomName,
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

            if (posts.isEmpty()) {
                EmptyListPlaceHolder(modifier = Modifier.weight(1f))
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp)
                        .padding(top = 20.dp)
                ) {
                    items(posts) { post ->
                        PostCard(post = post)
                        Spacer(modifier = Modifier.size(15.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun PostCard(post: PostData) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = 4.dp,
        modifier = Modifier.padding(8.dp)
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
                        .data(post.user.image)
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
                    post.user.username,
                    fontWeight = FontWeight.SemiBold,
                    style = mainTextStyleMin,
                    fontSize = 16.sp
                )
                Spacer(Modifier.weight(1f))
                Image(
                    painter = painterResource(R.drawable.report_icon),
                    contentDescription = "Profile picture",
                    modifier = Modifier
                        .size(25.dp),
                )
            }

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(post.media.firstOrNull() ?: R.drawable.login_screen_image)
                    //    .data(room.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = "Workout Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(15.dp)),
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                post.content,
                style = mainTextStyleMin,
                fontSize = 15.sp
            )
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.comment_dots),
                    contentDescription = "Background Image",
                    modifier = Modifier.size(25.dp),
                    contentScale = ContentScale.Fit
                )
                Text(
                    post.comments.toString(),
                    fontSize = 14.sp,
                    modifier = Modifier.padding(start = 4.dp),
                    style = mainTextStyleMin
                )
                Spacer(Modifier.weight(10f))
                if (post.report != null) {

                    Image(
                        painter = painterResource(id = R.drawable.heart_break_icon),
                        contentDescription = "",
                        modifier = Modifier.size(25.dp),
                        contentScale = ContentScale.Fit
                    )
                    Text(
                        post.report.dislike?.toString() ?: "0",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 4.dp),
                        style = mainTextStyleMin
                    )
                    Spacer(Modifier.weight(1f))
                    Image(
                        painter = painterResource(id = R.drawable.heart_icon),
                        contentDescription = "",
                        modifier = Modifier.size(25.dp),
                        contentScale = ContentScale.Fit
                    )
                    Text(
                        post.report.like?.toString() ?: "0",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 4.dp),
                        style = mainTextStyleMin
                    )
                }

            }
        }
    }
}

@Composable
fun WeekDaysRow() {

    val days = listOf("Thu", "Fri", "Sat", "Sun", "Mon", "Tue", "Wed")
    val dates = listOf(24, 25, 26, 27, 28, 29, 30)

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        items(days.zip(dates)) { (day, date) ->
            DayButton(day, date, isHighlighted = date == 26)
        }
    }
}

@Composable
fun DayButton(day: String, date: Int, isHighlighted: Boolean = false) {
    val backgroundColor = if (isHighlighted) mainPurple else Color.White
    val textColor = if (isHighlighted) Color.White else mainPurple

    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = 10.dp,
        backgroundColor = backgroundColor,
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
                color = textColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "$date",
                color = textColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

