package com.example.habiboo.domain.use_case.get_token

import com.example.habiboo.domain.repository.TokenRepository

class GetTokenUseCase(private val tokenRepository: TokenRepository) {
    suspend operator fun invoke(): String? {
        return tokenRepository.getToken()
    }
}