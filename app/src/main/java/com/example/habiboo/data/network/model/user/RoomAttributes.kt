package com.example.habiboo.data.network.model.user

data class RoomAttributes(
    val name: String,
    val description: String,
    val users: UsersResponse,
    val createdAt: String?,
    val updatedAt: String?
)
