package com.example.habiboo.presentation.screens.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.habiboo.R
import com.example.habiboo.domain.model.Habit
import com.example.habiboo.presentation.navigation.BottomNavigationBar
import com.example.habiboo.presentation.navigation.NavDestination
import com.example.habiboo.presentation.theme.PrimaryTextDark

@Composable
fun HomeScreen(navController: NavHostController, vm: HomeScreenViewModel = viewModel()) {

    val habitsState = vm.habits.observeAsState()
    val onAddBtnClicked  = {  navController.navigate(NavDestination.AddHabit.route)  }

    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar(navController) },
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

@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    )
    {

    }
}

@Composable
fun HabitList(habits: List<Habit>, onHabitClick: (String) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    )
    {
        items(habits) { h ->
            HabitCard(habit = h, onHabitClick)
            Spacer(modifier = Modifier.size(15.dp))
        }
    }
}

@Composable
fun HabitCard(habit: Habit,  onHabitClick: (String) -> Unit) {

    val image = if (habit.currentStreak < 3) R.drawable.poop_icon
                else R.drawable.fire_icon


    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onHabitClick(habit.id.toString())}
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

@Composable
fun EmptyListPlaceHolder() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "You have no habbits so far...\nStart right now!")
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun AddHabitButton(onAddBtnClicked:() -> Unit) {
    FloatingActionButton(
        onClick = { onAddBtnClicked() },
        modifier = Modifier.clip(RoundedCornerShape(100.dp))
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.add_baseline),
            contentDescription = "Add Habit",
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}
