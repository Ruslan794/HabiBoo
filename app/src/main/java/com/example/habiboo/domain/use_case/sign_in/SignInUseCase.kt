package com.example.habiboo.domain.use_case.sign_in

import com.example.habiboo.domain.model.User
import com.example.habiboo.domain.repository.AuthRepository

class SignInUseCase(private val authRepository: AuthRepository) {
    fun execute(email: String, password: String): User {
        return authRepository.signIn(email, password)
    }
}
