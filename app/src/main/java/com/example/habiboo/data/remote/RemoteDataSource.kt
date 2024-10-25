package com.example.habiboo.data.remote

import com.example.habiboo.data.network.model.userAuth.LoginRequest
import com.example.habiboo.data.network.services.UserAuthApiService
import com.example.habiboo.domain.model.AuthResponse
import com.example.habiboo.domain.model.User
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val authService: UserAuthApiService
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
}
