package com.example.habiboo.domain.repository

import com.example.habiboo.domain.model.AuthResponse
import com.example.habiboo.domain.model.User
import retrofit2.Response


interface AuthRepository {
    suspend fun signIn(email: String, password: String): Response<AuthResponse>
    suspend fun signUp(email: String, username: String, password: String): Result<User>
    suspend fun signOut(): Result<Unit>
}