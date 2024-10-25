package com.example.habiboo.domain.repository

import com.example.habiboo.domain.model.Room
import retrofit2.Response

interface RoomsRepository {
    fun getAllRooms(): Response<List<Room>>
    fun getRoomDetails(roomId: String): Result<Room>
    fun joinRoom(roomId: String): Result<Unit>
    fun leaveRoom(roomId: String): Result<Unit>
}