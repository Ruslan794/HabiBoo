package com.example.habiboo.domain.use_case.get_room_posts

import com.example.habiboo.data.network.model.post.PostResponse
import com.example.habiboo.domain.repository.RoomsRepository
import retrofit2.Response
import javax.inject.Inject

class GetRoomPostsUseCase @Inject constructor(
    private val repository: RoomsRepository
) {
    suspend fun execute(roomId: String): Response<PostResponse> {
        return repository.getRoomPosts(roomId)
    }
}