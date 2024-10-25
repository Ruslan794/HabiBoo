package com.example.habiboo.data.repository

import android.util.Log
import com.example.habiboo.data.network.model.room.Room
import com.example.habiboo.data.network.model.room.TopRoomsResponse
import com.example.habiboo.data.remote.RemoteDataSource
import com.example.habiboo.domain.repository.RoomsRepository
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class RoomsRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : RoomsRepository {
    override suspend fun getAllRooms(): Response<TopRoomsResponse> {
        return remoteDataSource.getTopRooms()
    }

    override suspend fun getMyRooms(): Response<TopRoomsResponse> {
        return remoteDataSource.getMyRooms()
    }

    override fun getRoomDetails(roomId: String): Result<Room> {
        TODO("Not yet implemented")
    }

    override fun joinRoom(roomId: String): Result<Unit> {
        TODO("Not yet implemented")
    }

    override fun leaveRoom(roomId: String): Result<Unit> {
        TODO("Not yet implemented")
    }
}