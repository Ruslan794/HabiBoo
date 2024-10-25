package com.example.habiboo.domain.use_case.sign_out

import com.example.habiboo.domain.repository.AuthRepository

class SignOutUseCase(private val authRepository: AuthRepository) {
    fun execute(): Result<Unit> {
        return authRepository.signOut()
    }
}
