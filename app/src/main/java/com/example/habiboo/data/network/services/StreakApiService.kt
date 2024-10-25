package com.example.habiboo.data.network.services

import retrofit2.Response
import retrofit2.http.*

interface StreakService {

    @GET("/getUserStreak/room/{roomId}")
    suspend fun getUserStreakByRoomId(
        @Path("roomId") roomId: String
    ): Response<StreakResponse>

    @GET("/streaks")
    suspend fun getAllStreaks(): Response<List<StreakResponse>>

    @POST("/streaks")
    suspend fun createStreak(
        @Body streakRequest: StreakRequest
    ): Response<StreakResponse>

    @GET("/streaks/{id}")
    suspend fun getStreakById(
        @Path("id") streakId: String
    ): Response<StreakResponse>

    @PUT("/streaks/{id}")
    suspend fun updateStreak(
        @Path("id") streakId: String,
        @Body streakRequest: StreakRequest
    ): Response<StreakResponse>

    @DELETE("/streaks/{id}")
    suspend fun deleteStreak(
        @Path("id") streakId: String
    ): Response<Unit>
}
