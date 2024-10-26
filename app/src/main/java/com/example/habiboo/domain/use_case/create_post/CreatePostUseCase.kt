package com.example.habiboo.domain.use_case.create_post

import com.example.habiboo.domain.repository.RoomsRepository
import retrofit2.Response
import javax.inject.Inject

class CreatePostUseCase @Inject constructor(
    private val repository: RoomsRepository
) {
    suspend fun execute(content: String, roomId: Int): Response<Void> {
        return repository.createPost(content, roomId)
    }
}
