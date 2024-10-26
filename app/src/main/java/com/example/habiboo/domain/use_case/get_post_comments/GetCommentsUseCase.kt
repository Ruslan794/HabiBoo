package com.example.habiboo.domain.use_case.get_post_comments

import com.example.habiboo.data.network.model.comment.CommentResponse
import com.example.habiboo.domain.repository.RoomsRepository
import retrofit2.Response
import javax.inject.Inject

class GetCommentsUseCase @Inject constructor(
    private val repository: RoomsRepository
) {
    suspend fun execute(postId: String): Response<CommentResponse> {
        return repository.getPostComments(postId)
    }
}