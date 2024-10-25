package com.example.habiboo.domain.use_case.save_token

import com.example.habiboo.domain.repository.TokenRepository

// Domain Layer: Use Case для сохранения токена
class SaveTokenUseCase(private val tokenRepository: TokenRepository) {
    suspend operator fun invoke(token: String) {
        tokenRepository.saveToken(token)
    }
}
