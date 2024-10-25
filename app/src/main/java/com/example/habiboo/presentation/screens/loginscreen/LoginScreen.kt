package com.example.habiboo.presentation.screens.loginscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.habiboo.presentation.navigation.NavDestination
import com.example.habiboo.presentation.screens.homescreen.AddHabitButton
import com.example.habiboo.presentation.screens.homescreen.EmptyListPlaceHolder
import com.example.habiboo.presentation.screens.homescreen.HabitList
import com.example.habiboo.presentation.screens.homescreen.HomeScreenViewModel
import com.example.habiboo.presentation.screens.homescreen.TopBar



@Composable
fun LoginScreen(navController: NavHostController ){
    Row {
      Text(text ="HabiBoo", )
    }
}

@Composable
fun HomeScreen(navController: NavHostController, vm: HomeScreenViewModel = viewModel()) {

    val habitsState = vm.habits.observeAsState()
    val onAddBtnClicked  = {  navController.navigate(NavDestination.AddHabit.route)  }

    Scaffold(
        topBar = { TopBar() },
        floatingActionButton = { AddHabitButton(onAddBtnClicked = onAddBtnClicked) },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                if (habitsState.value?.isEmpty() == true) {
                    EmptyListPlaceHolder()
                } else {
                    habitsState.value?.let { HabitList(it,
                        onHabitClick = { habitId ->
                            //   navController.navigate(NavDestination.A.createRoute(habitId))
                        })  }
                }
            }
        }
    )

}