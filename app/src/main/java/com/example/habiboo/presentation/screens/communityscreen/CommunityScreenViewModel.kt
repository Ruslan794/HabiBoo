package com.example.habiboo.presentation.screens.communityscreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habiboo.data.network.model.room.Pagination
import com.example.habiboo.data.network.model.room.Room
import com.example.habiboo.domain.model.Habit
import com.example.habiboo.domain.model.NotificationSettings
import com.example.habiboo.domain.model.Task
import com.example.habiboo.domain.use_case.get_all_rooms.GetAllRoomsUseCase
import com.example.habiboo.domain.use_case.get_all_rooms.GetMyRoomsUseCase
import com.example.habiboo.domain.use_case.join_room.JoinRoomUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class CommunityScreenViewModel @Inject constructor(
    private val getMyRoomsUseCase: GetMyRoomsUseCase,
    private val joinRoomUseCase: JoinRoomUseCase
) : ViewModel() {

    private val _rooms = MutableLiveData<List<Room>>()
    val rooms: LiveData<List<Room>> get() = _rooms

    private val _searchQuery = MutableLiveData<String>("")
    val searchQuery: LiveData<String> get() = _searchQuery

    private val _filteredRooms = MutableLiveData<List<Room>>()
    val filteredRooms: LiveData<List<Room>> get() = _filteredRooms

    init {
        fetchRooms()
    }

    private fun fetchRooms(page: Int = 1, pageSize: Int = 10) {
        viewModelScope.launch {
            // Ваш существующий код для загрузки комнат
            val response = getMyRoomsUseCase.execute()
            if (response.isSuccessful) {
                val topRoomsResponse = response.body()
                if (topRoomsResponse != null) {
                    _rooms.value = topRoomsResponse.data
                    filterRooms()
                }
            } else {
                // Обработка ошибки
            }
        }
    }

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
        filterRooms()
    }

    private fun filterRooms() {
        val rooms = _rooms.value ?: emptyList()
        val query = _searchQuery.value ?: ""
        _filteredRooms.value = if (query.isEmpty()) {
            rooms
        } else {
            rooms.filter { room ->
                room.name.contains(query, ignoreCase = true)
            }
        }
    }

    fun joinRoom(roomId: String, password: String?) {
        viewModelScope.launch {
            try {
                val response = joinRoomUseCase.execute(roomId, password)
                if (response.isSuccessful) {
                    // Успешно присоединились к комнате
                    // Обновите состояние или выполните нужные действия
                } else {
                    // Обработка ошибки
                    val errorBody = response.errorBody()?.string()
                    Log.e("CommunityScreenViewModel", "Error joining room: $errorBody")
                }
            } catch (e: Exception) {
                Log.e("CommunityScreenViewModel", "Exception: ${e.message}")
                // Обработка исключения
            }
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
