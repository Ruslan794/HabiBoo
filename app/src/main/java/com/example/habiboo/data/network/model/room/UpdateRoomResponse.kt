package com.example.habiboo.data.network.model.room

data class UpdateRoomResponse(
    val data: RoomResponseData,
    val meta: Map<String, Any>? // Use Map<String, Any> if meta details are unknown
)
