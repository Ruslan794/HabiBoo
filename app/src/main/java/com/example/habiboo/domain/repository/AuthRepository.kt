package com.example.habiboo.domain.repository

import com.example.habiboo.domain.model.AuthResponse
import com.example.habiboo.domain.model.User


interface AuthRepository {
    fun signIn(email: String, password: String): Result<AuthResponse>
    fun signUp(email: String, username: String, password: String): Result<User>
    fun signOut(): Result<Unit>
}