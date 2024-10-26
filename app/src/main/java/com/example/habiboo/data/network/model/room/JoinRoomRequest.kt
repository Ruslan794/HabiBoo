package com.example.habiboo.data.network.model.room

data class JoinRoomRequest(
    val roomId: String,
    val password: String?
)