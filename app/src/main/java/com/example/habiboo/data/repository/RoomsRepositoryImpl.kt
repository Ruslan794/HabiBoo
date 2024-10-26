package com.example.habiboo.data.repository

import android.util.Log
import com.example.habiboo.data.network.model.comment.CommentResponse
import com.example.habiboo.data.network.model.post.PostResponse
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

    override suspend fun getRoomPosts(roomId: String): Response<PostResponse> {
        return remoteDataSource.getRoomPosts(roomId)
    }

    override suspend fun getPostComments(postId: String): Response<CommentResponse> {
        return remoteDataSource.getPostComments(postId)
    }

    override suspend fun joinRoom(roomId: String, password: String?): Response<Void> {
        return remoteDataSource.joinRoom(roomId, password)
    }

    override fun leaveRoom(roomId: String): Result<Unit> {
        TODO("Not yet implemented")
    }
}