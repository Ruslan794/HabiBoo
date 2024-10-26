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

    fun fetchRoomPosts(roomId: String) {
        viewModelScope.launch {
            try {
                val response = getRoomPostsUseCase.execute(roomId)
                if (response.isSuccessful) {
                    val postsResponse = response.body()
                    _posts.value = postsResponse?.data ?: emptyList()
                } else {
                    // Обработка ошибки
                }
            } catch (e: Exception) {
                // Обработка исключения
            }
        }
    }
}
