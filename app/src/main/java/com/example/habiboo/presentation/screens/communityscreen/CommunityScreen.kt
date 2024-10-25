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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.habiboo.common.RoomCard
import com.example.habiboo.common.SearchBar
import com.example.habiboo.domain.model.Room
import com.example.habiboo.presentation.navigation.BottomNavigationBar
import com.example.habiboo.presentation.screens.homescreen.HomeScreenViewModel
import com.example.habiboo.presentation.theme.backgroundWhite

@Composable
fun CommunityScreen (navController: NavHostController, vm: HomeScreenViewModel = viewModel()) {

    val roomsState = vm.rooms.observeAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundWhite)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color.Transparent),
            contentAlignment = Alignment.TopCenter
        ) {
            SearchBar()
        }

        if (roomsState.value?.isEmpty() == true) {
            EmptyListPlaceHolder()
        } else {
            roomsState.value?.let {
                RoomList(
                    it,
                    onRoomClick = { habitId ->
                        // navController.navigate(NavDestination.A.createRoute(habitId))
                    },
                )
            }
        }

        BottomNavigationBar(navController = navController)

    }
}

@Composable
fun RoomList(rooms: List<Room>, onRoomClick: (String) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .padding(vertical = 56.dp)
    )
    {
        items(rooms) { r ->
            RoomCard(room = r, onRoomClick)
            Spacer(modifier = Modifier.size(15.dp))
        }
    }
}

@Composable
fun EmptyListPlaceHolder() {
    Column(
        modifier = Modifier
            .padding(bottom = 56.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "You have no rooms so far...\nStart right now!")
        Spacer(modifier = Modifier.height(20.dp))
    }
}