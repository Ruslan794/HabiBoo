package com.example.habiboo.presentation.screens.roomScreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habiboo.data.network.model.post.PostData
import com.example.habiboo.domain.use_case.create_post.CreatePostUseCase
import com.example.habiboo.domain.use_case.get_room_posts.GetRoomPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor(
    private val getRoomPostsUseCase: GetRoomPostsUseCase,
    private val createPostUseCase: CreatePostUseCase
) : ViewModel() {

    private val _posts = MutableLiveData<List<PostData>>()
    val posts: LiveData<List<PostData>> = _posts

    private val _roomName = MutableLiveData<String>()
    val roomName: LiveData<String> = _roomName

    private val _roomGoal = MutableLiveData<String>()
    val roomGoal: LiveData<String> = _roomGoal

    private val _currentUserStreak = MutableLiveData<Int>()
    val currentUserStreak: LiveData<Int> = _currentUserStreak

    private val _postContent = MutableLiveData<String>()
    val postContent: LiveData<String> = _postContent

    fun fetchRoomPosts(roomId: String) {
        viewModelScope.launch {
            try {
                val response = getRoomPostsUseCase.execute(roomId)
                if (response.isSuccessful) {
                    val postsResponse = response.body()
                    _roomName.value = postsResponse?.data?.name ?: "Unknown Room"
                    _roomGoal.value = postsResponse?.data?.goal ?: "No Goal"
                    _posts.value = postsResponse?.data?.posts ?: emptyList()

                    _currentUserStreak.value = postsResponse?.data?.current_user_streak ?: 0
                } else {
                    // Обработка ошибки
                }
            } catch (e: Exception) {
                // Обработка исключения
            }
        }
    }

    fun onPostContentChanged(content: String) {
        _postContent.value = content
    }

    fun createPost(roomId: Int) {
        val content = _postContent.value ?: return
        viewModelScope.launch {
            try {
                val response = createPostUseCase.execute(content, roomId)
                if (response.isSuccessful) {
                    // Обновляем список постов
                    fetchRoomPosts(roomId.toString())
                    // Очищаем поле ввода
                    _postContent.value = ""
                } else {
                    // Обработка ошибки
                    val errorBody = response.errorBody()?.string()
                    Log.e("RoomViewModel", "Error creating post: $errorBody")
                }
            } catch (e: Exception) {
                Log.e("RoomViewModel", "Exception: ${e.message}")
                // Обработка исключения
            }
        }
    }

}
