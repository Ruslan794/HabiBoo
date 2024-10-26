package com.example.habiboo.presentation.screens.commentsscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habiboo.data.network.model.comment.CommentData
import com.example.habiboo.domain.use_case.get_post_comments.GetCommentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.w3c.dom.Comment
import javax.inject.Inject

@HiltViewModel
class CommentsViewModel @Inject constructor(
    private val getCommentsUseCase: GetCommentsUseCase,
//    private val addCommentUseCase: AddCommentUseCase
) : ViewModel() {

    private val _comments = MutableLiveData<List<CommentData>>()
    val comments: LiveData<List<CommentData>> = _comments

    private val _commentContent = MutableLiveData<String>()
    val commentContent: LiveData<String> = _commentContent

    fun fetchComments(postId: String) {
        viewModelScope.launch {
            try {
                val response = getCommentsUseCase.execute(postId)
                if (response.isSuccessful) {
                    _comments.value = response.body()?.data ?: emptyList()
                } else {
                    // Обработка ошибки
                }
            } catch (e: Exception) {
                // Обработка исключения
            }
        }
    }

    fun onCommentContentChanged(content: String) {
        _commentContent.value = content
    }

//    fun addComment(postId: String) {
//        val content = _commentContent.value ?: return
//        viewModelScope.launch {
//            try {
//                val response = addCommentUseCase.execute(postId, content)
//                if (response.isSuccessful) {
//                    // Обновляем список комментариев
//                    fetchComments(postId)
//                    // Очищаем поле ввода
//                    _commentContent.value = ""
//                } else {
//                    // Обработка ошибки
//                }
//            } catch (e: Exception) {
//                // Обработка исключения
//            }
//        }
//    }
}
