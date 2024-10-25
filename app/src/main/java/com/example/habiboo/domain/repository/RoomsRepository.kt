package com.example.habiboo.domain.repository

import com.example.habiboo.domain.model.Room

interface RoomsRepository {
    fun getAllRooms(): List<Room>
    fun getRoomDetails(roomId: String): Room
    fun joinRoom(roomId: String): Unit
    fun leaveRoom(roomId: String): Unit
}