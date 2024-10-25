package com.example.habiboo.domain.use_case.sign_in

import com.example.habiboo.domain.model.AuthResponse
import com.example.habiboo.domain.repository.AuthRepository
import retrofit2.Response
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend fun execute(email: String, password: String): Response<AuthResponse> {
        return authRepository.signIn(email, password)
    }
}

