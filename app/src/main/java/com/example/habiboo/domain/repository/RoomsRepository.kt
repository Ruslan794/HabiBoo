package com.example.habiboo.domain.repository

import com.example.habiboo.data.network.model.comment.CommentRequest
import com.example.habiboo.data.network.model.comment.CommentResponse
import com.example.habiboo.data.network.model.post.PostResponse
import com.example.habiboo.data.network.model.room.Room
import com.example.habiboo.data.network.model.room.TopRoomsResponse
import retrofit2.Response

interface RoomsRepository {
    suspend fun getAllRooms(): Response<TopRoomsResponse>
    suspend fun getMyRooms(): Response<TopRoomsResponse>
    fun getRoomDetails(roomId: String): Result<Room>
    suspend fun getRoomPosts(roomId: String): Response<PostResponse>
    suspend fun getPostComments(postId: String): Response<CommentResponse>
    suspend fun addComment(postId: String, content: String): Response<Void>
    suspend fun createPost(content: String, roomId: Int): Response<Void>
    suspend fun joinRoom(roomId: String, password: String?): Response<Void>
    fun leaveRoom(roomId: String): Result<Unit>
}