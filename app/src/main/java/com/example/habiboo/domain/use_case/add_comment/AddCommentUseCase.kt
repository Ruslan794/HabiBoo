package com.example.habiboo.domain.use_case.add_comment

import com.example.habiboo.domain.repository.RoomsRepository
import retrofit2.Response
import javax.inject.Inject

class AddCommentUseCase @Inject constructor(
    private val repository: RoomsRepository
) {
    suspend fun execute(postId: String, content: String): Response<Void> {
        return repository.addComment(postId, content)
    }
}