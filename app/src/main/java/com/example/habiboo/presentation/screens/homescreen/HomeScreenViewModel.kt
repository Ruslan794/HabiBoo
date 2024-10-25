package com.example.habiboo.presentation.screens.homescreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habiboo.domain.model.Habit
import com.example.habiboo.domain.model.NotificationSettings
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class HomeScreenViewModel : ViewModel() {

    private val _habits = MutableLiveData<List<Habit>>()
    val habits: LiveData<List<Habit>> get() = _habits

    init {
        updateHabitsList()
    }

    fun updateHabitsList() {
        viewModelScope.launch {
            // _habits.value = emptyList()
            // delay(2000)
            _habits.value = habitsSample
        }
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
