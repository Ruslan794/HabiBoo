package com.example.habiboo.data.network.model.user

data class UserAttributes(
    val username: String,
    val email: String,
    val provider: String,
    val confirmed: Boolean,
    val blocked: Boolean
)
