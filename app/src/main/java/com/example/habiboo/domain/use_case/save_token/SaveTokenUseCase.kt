package com.example.habiboo.domain.use_case.save_token

import com.example.habiboo.domain.repository.TokenRepository
import javax.inject.Inject

// Domain Layer: Use Case для сохранения токена
class SaveTokenUseCase @Inject constructor(
    private val tokenRepository: TokenRepository
) {
    suspend operator fun invoke(token: String) = tokenRepository.saveToken(token)
}

