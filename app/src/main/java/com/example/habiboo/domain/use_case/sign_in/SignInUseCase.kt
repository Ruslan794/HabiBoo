package com.example.habiboo.domain.use_case.sign_in

import com.example.habiboo.domain.model.AuthResponse
import com.example.habiboo.domain.model.User
import com.example.habiboo.domain.repository.AuthRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend fun execute(email: String, password: String): Result<AuthResponse> {
        return authRepository.signIn(email, password)
    }
}

