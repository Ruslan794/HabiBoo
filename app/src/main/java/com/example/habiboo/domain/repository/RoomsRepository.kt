package com.example.habiboo.domain.repository

import com.example.habiboo.domain.model.Room

interface RoomsRepository {
    fun getAllRooms(): Result<List<Room>>
    fun getRoomDetails(roomId: String): Result<Room>
    fun joinRoom(roomId: String): Result<Unit>
    fun leaveRoom(roomId: String): Result<Unit>
}