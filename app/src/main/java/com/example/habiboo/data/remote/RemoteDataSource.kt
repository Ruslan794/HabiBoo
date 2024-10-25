package com.example.habiboo.data.remote

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

    suspend fun getTopRooms(page: Int = 1, pageSize: Int = 10): Response<TopRoomsResponse> {
        return roomsApiService.getTopRooms(page, pageSize)
    }

    suspend fun getMyRooms(page: Int = 1, pageSize: Int = 10): Response<TopRoomsResponse> {
        val token = tokenRepository.getToken()
        val authHeader = "Bearer $token"
        return roomsApiService.getMyRooms(
//            authorization = authHeader,
            page = page,
            pageSize = pageSize
        )
    }
}
