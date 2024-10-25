package com.example.habiboo.data.network.model.userAuth

data class ChangePasswordRequest(
    val password: String,
    val currentPassword: String,
    val passwordConfirmation: String
)
