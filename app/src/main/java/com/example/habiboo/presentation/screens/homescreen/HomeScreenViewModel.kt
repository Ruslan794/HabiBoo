package com.example.habiboo.presentation.screens.homescreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habiboo.domain.model.Habit
import com.example.habiboo.domain.model.NotificationSettings
import com.example.habiboo.domain.model.Room
import com.example.habiboo.domain.model.Task
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class HomeScreenViewModel : ViewModel() {

    private val _rooms = MutableLiveData<List<Room>>()
    val rooms: LiveData<List<Room>> get() = _rooms

    init {
        updateHabitsList()
    }

    fun updateHabitsList() {
        viewModelScope.launch {
            // _habits.value = emptyList()
            // delay(2000)
            _rooms.value = generateSampleRooms()
        }
    }



    fun generateSampleRooms(): List<Room> {
        val rooms = mutableListOf<Room>()
        for (i in 1..10) {
            rooms.add(
                Room(
                    id = "room$i",
                    name = "Room $i",
                    description = "Description of Room $i with detailed info.",
                    maxMembers = 10 + i,  // Example variation
                    currentMembers = 1 + i,  // Increment to show variety
                    isPrivate = i % 2 == 0,  // Alternate between private and public
                    imageUrl = if (i % 3 == 0) "http://example.com/image$i.jpg" else null,  // Some have images, some don't
                    tasks = listOf(
                        Task(id = "task${i}1", name = "Task ${i}1", description = "Task ${i}1 description", isCompleted = false),
                        Task(id = "task${i}2", name = "Task ${i}2", description = "Task ${i}2 description", isCompleted = true)
                    )
                )
            )
        }
        return rooms
    }


}










val habitsSample = listOf(
    Habit(
        id = 1,
        name = "Подрочить левой рукой",
        note = "Дрочить левой рукой не удобно",
        notifications = NotificationSettings(true, true, false),
        dateOfCreation = LocalDateTime.now().minusDays(30),
        repetitions = listOf(
            LocalDateTime.now().minusDays(1),
            LocalDateTime.now().minusDays(2),
            LocalDateTime.now().minusDays(3)
        ),
        currentStreak = 3,
        biggestStreak = 10,
        periodOfBiggestStreak = Pair(LocalDateTime.now().minusDays(10), LocalDateTime.now()),
        isDeleted = false
    ),
    Habit(
        id = 2,
        name = "Фап фап правой",
        note = "Оч удобно",
        notifications = NotificationSettings(
            notificationsEnabled = true,
            timedNotificationsEnabled = true,
            randomNotificationsEnabled = true
        ),
        dateOfCreation = LocalDateTime.now().minusDays(20),
        repetitions = listOf(
            LocalDateTime.now().minusDays(1),
            LocalDateTime.now().minusDays(2),
            LocalDateTime.now().minusDays(3)
        ),
        currentStreak = 13,
        biggestStreak = 13,
        periodOfBiggestStreak = Pair(
            LocalDateTime.now().minusDays(7),
            LocalDateTime.now().minusDays(1)
        ),
        isDeleted = false
    ),
    Habit(
        id = 3,
        name = "подрочить обоими руками",
        note = ".",
        notifications = NotificationSettings(false, false, false),
        dateOfCreation = LocalDateTime.now().minusDays(15),
        repetitions = listOf(
            LocalDateTime.now().minusDays(1),
            LocalDateTime.now().minusDays(3),
            LocalDateTime.now().minusDays(4)
        ),
        currentStreak = 1,
        biggestStreak = 5,
        periodOfBiggestStreak = Pair(LocalDateTime.now().minusDays(5), LocalDateTime.now()),
        isDeleted = false
    ),
    Habit(
        id = 4,
        name = "Подрочить рукой Владика",
        note = "Не обязательно чтоб он знал",
        notifications = NotificationSettings(true, false, true),
        dateOfCreation = LocalDateTime.now().minusDays(10),
        repetitions = listOf(
            LocalDateTime.now().minusDays(1),
            LocalDateTime.now().minusDays(2),
            LocalDateTime.now().minusDays(3)
        ),
        currentStreak = 100,
        biggestStreak = 100,
        periodOfBiggestStreak = Pair(
            LocalDateTime.now().minusDays(3),
            LocalDateTime.now().minusDays(1)
        ),
        isDeleted = false
    ),
    Habit(
        id = 5,
        name = "Подрочить рукой Сережи",
        note = "",
        notifications = NotificationSettings(true, true, false),
        dateOfCreation = LocalDateTime.now().minusDays(5),
        repetitions = listOf(
            LocalDateTime.now().minusDays(1),
            LocalDateTime.now().minusDays(2),
            LocalDateTime.now().minusDays(3)
        ),
        currentStreak = 3,
        biggestStreak = 3,
        periodOfBiggestStreak = Pair(
            LocalDateTime.now().minusDays(3),
            LocalDateTime.now().minusDays(1)
        ),
        isDeleted = false
    )
)
