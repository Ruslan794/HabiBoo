package com.example.habiboo.data.network.model.userAuth

data class ResetPasswordRequest(
    val password: String,
    val passwordConfirmation: String,
    val code: String
)
