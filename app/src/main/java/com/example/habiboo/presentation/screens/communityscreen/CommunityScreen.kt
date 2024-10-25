package com.example.habiboo.presentation.screens.communityscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.habiboo.common.RoomCard
import com.example.habiboo.common.SearchBar
import com.example.habiboo.presentation.navigation.BottomNavigationBar
import com.example.habiboo.presentation.screens.homescreen.HomeScreenViewModel
import com.example.habiboo.presentation.theme.backgroundWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommunityScreen(navController: NavHostController, vm: CommunityScreenViewModel = hiltViewModel()) {

    val roomsState = vm.rooms.observeAsState()
    val searchQuery by vm.searchQuery.observeAsState("")
    val filteredRooms by vm.filteredRooms.observeAsState(emptyList())


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Community")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                    scrolledContainerColor = Color.Transparent
                )
            )
        },
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundWhite)
                .padding(paddingValues)
        ) {
            SearchBar(
                value = searchQuery,
                onValueChange = { vm.onSearchQueryChanged(it) }
            )

            if (filteredRooms.isEmpty()) {
                com.example.habiboo.presentation.screens.homescreen.EmptyListPlaceHolder(
                    modifier = Modifier.weight(
                        1f
                    )
                )
            } else {
                com.example.habiboo.presentation.screens.homescreen.RoomList(
                    rooms = filteredRooms,
                    onRoomClick = { roomId ->
                        // Обработка клика по комнате
                    },
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun RoomList(rooms: List<com.example.habiboo.data.network.model.room.Room>, onRoomClick: (String) -> Unit, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp)
    ) {
        items(rooms) { room ->
            RoomCard(room = room, onRoomClick)
            Spacer(modifier = Modifier.size(15.dp))
        }
    }
}

@Composable
fun EmptyListPlaceHolder(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 56.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "No rooms available in the community...\nStart one now!")
        Spacer(modifier = Modifier.height(20.dp))
    }
}