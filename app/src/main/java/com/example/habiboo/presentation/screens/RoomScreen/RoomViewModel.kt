package com.example.habiboo.presentation.screens.RoomScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habiboo.data.network.model.post.Post
import com.example.habiboo.data.network.model.post.PostData
import com.example.habiboo.domain.use_case.get_room_posts.GetRoomPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor(
    private val getRoomPostsUseCase: GetRoomPostsUseCase
) : ViewModel() {

    private val _posts = MutableLiveData<List<PostData>>()
    val posts: LiveData<List<PostData>> = _posts

    private val _roomName = MutableLiveData<String>()
    val roomName: LiveData<String> = _roomName

    private val _roomGoal = MutableLiveData<String>()
    val roomGoal: LiveData<String> = _roomGoal


    fun fetchRoomPosts(roomId: String) {
        viewModelScope.launch {
            try {
                val response = getRoomPostsUseCase.execute(roomId)
                if (response.isSuccessful) {
                    val postsResponse = response.body()
                    _roomName.value = postsResponse?.data?.name ?: "Unknown Room"
                    _roomGoal.value = postsResponse?.data?.goal ?: "No Goal"
                    _posts.value = postsResponse?.data?.posts ?: emptyList()
                } else {
                    // Обработка ошибки
                }
            } catch (e: Exception) {
                // Обработка исключения
            }
        }
    }
}
