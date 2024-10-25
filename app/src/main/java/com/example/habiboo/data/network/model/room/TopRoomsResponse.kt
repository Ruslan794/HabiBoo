package com.example.habiboo.data.network.model.room

data class TopRoomsResponse(
    val data: List<Room>,
    val pagination: Pagination
)
