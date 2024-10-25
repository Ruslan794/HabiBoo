package com.example.habiboo.data.network.services

import com.example.habiboo.data.network.model.streak.CreateStreakRequest
import com.example.habiboo.data.network.model.streak.StreakResponse
import retrofit2.Response
import retrofit2.http.*

interface StreakService {

    @GET("/getUserStreak/room/{roomId}")
    suspend fun getUserStreakByRoomId(
        @Path("roomId") roomId: String
    ): Response<StreakResponse>

    @GET("/streaks")
    suspend fun getAllStreaks(
        @Query("sort") sort: String? = null,
        @Query("pagination[withCount]") withCount: Boolean? = true,
        @Query("pagination[page]") page: Int? = 0,
        @Query("pagination[pageSize]") pageSize: Int? = 25,
        @Query("pagination[start]") start: Int? = 0,
        @Query("pagination[limit]") limit: Int? = 25,
        @Query("fields") fields: String? = null,
        @Query("populate") populate: String? = null,
        @Query("filters") filters: String? = null
    ): Response<StreakResponse>

    @POST("/streaks")
    suspend fun createStreak(
        @Body request: CreateStreakRequest
    ): Response<StreakResponse>

    @GET("/streaks/{id}")
    suspend fun getStreakById(
        @Path("id") streakId: String
    ): Response<StreakResponse>

    @PUT("/streaks/{id}")
    suspend fun updateStreak(
        @Path("id") streakId: Int,
        @Body request: CreateStreakRequest
    ): Response<StreakResponse>


    @DELETE("/streaks/{id}")
    suspend fun deleteStreak(
    @Path("id") streakId: Int
    ): Response<Unit>
}
