package com.example.habiboo.domain.use_case.sign_up

import com.example.habiboo.domain.model.User
import com.example.habiboo.domain.repository.AuthRepository

class SignUpUseCase(private val authRepository: AuthRepository) {
    fun execute(email: String, username: String, password: String): User {
        return authRepository.signUp(email, username, password)
    }
}