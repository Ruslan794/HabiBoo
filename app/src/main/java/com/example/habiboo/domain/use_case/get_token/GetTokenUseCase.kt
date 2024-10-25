package com.example.habiboo.domain.use_case.get_token

import com.example.habiboo.domain.repository.TokenRepository
import javax.inject.Inject

class GetTokenUseCase @Inject constructor(
    private val tokenRepository: TokenRepository
) {
    suspend operator fun invoke(): String? = tokenRepository.getToken()
}
