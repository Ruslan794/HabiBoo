package com.example.habiboo.data.remote

import com.example.habiboo.data.network.model.comment.CommentDataInput
import com.example.habiboo.data.network.model.comment.CommentRequest
import com.example.habiboo.data.network.model.comment.CommentResponse
import com.example.habiboo.data.network.model.post.PostResponse
import com.example.habiboo.data.network.model.room.EnterRoomRequest
import com.example.habiboo.data.network.model.room.TopRoomsResponse
import com.example.habiboo.data.network.model.userAuth.LoginRequest
import com.example.habiboo.data.network.services.RoomsApiService
import com.example.habiboo.data.network.services.UserAuthApiService
import com.example.habiboo.domain.model.AuthResponse
import com.example.habiboo.domain.model.User
import com.example.habiboo.domain.repository.TokenRepository
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val authService: UserAuthApiService,
    private val roomsApiService: RoomsApiService,
    private val tokenRepository: TokenRepository
) {

    suspend fun signIn(email: String, password: String): Response<AuthResponse> {
        val loginRequest = LoginRequest(identifier = email, password = password)
        return authService.login(loginRequest)
    }

    fun signUp(email: String, username: String, password: String): User {
        // Simulate API call and response for sign-up
        return User(
            blocked = false,
            confirmed = true,
            createdAt = "2024-01-01T12:00:00Z",
            email = email,
            id = 2,
            provider = "local",
            updatedAt = "2024-10-25T12:00:00Z",
            username = username
        )
    }

    fun signOut() {
        // Optionally handle remote sign-out
    }

    suspend fun getTopRooms(page: Int = 1, pageSize: Int = 100): Response<TopRoomsResponse> {
        return roomsApiService.getTopRooms(page, pageSize)
    }

    suspend fun getMyRooms(page: Int = 1, pageSize: Int = 100): Response<TopRoomsResponse> {
        val token = tokenRepository.getToken()
        val authHeader = "Bearer $token"
        return roomsApiService.getMyRooms(
//            authorization = authHeader,
            page = page,
            pageSize = pageSize
        )
    }

    suspend fun joinRoom(roomId: String, password: String?): Response<Void> {
        val request = EnterRoomRequest(roomId.toInt(), password.toString())
        return roomsApiService.joinRoom(request)
    }

    suspend fun getRoomPosts(roomId: String, page: Int = 1, pageSize: Int = 100): Response<PostResponse> {
        return roomsApiService.getRoomPosts(roomId, page, pageSize)
    }

    suspend fun getPostComments(postId: String): Response<CommentResponse> {
        return roomsApiService.getPostComments(postId)
    }

    suspend fun addComment(comment: CommentDataInput): Response<Void> {
        return roomsApiService.addComment(comment)
    }
}
