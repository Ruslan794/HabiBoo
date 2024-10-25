package com.example.habiboo.domain.repository

// Domain Layer: интерфейс для TokenRepository
interface TokenRepository {
    suspend fun saveToken(token: String)
    suspend fun getToken(): String?
    suspend fun clearToken()
}
