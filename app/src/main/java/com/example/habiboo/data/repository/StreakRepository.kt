package com.example.habiboo.data.repository

import com.example.habiboo.data.network.model.streak.CreateStreakRequest
import com.example.habiboo.data.network.model.streak.StreakResponse
import com.example.habiboo.data.network.services.StreakService

class StreakRepository(private val streakService: StreakService) {

    // Get user streak by room ID
    suspend fun getUserStreakByRoomId(roomId: String): Result<StreakResponse> {
        return try {
            val response = streakService.getUserStreakByRoomId(roomId)
            if (response.isSuccessful) {
                response.body()?.let {
                    Result.success(it)
                } ?: Result.failure(Exception("No data found"))
            } else {
                Result.failure(Exception("Error: ${response.code()} ${response.message()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Get all streaks with optional filters and pagination
    suspend fun getAllStreaks(
        sort: String? = null,
        withCount: Boolean? = true,
        page: Int? = 0,
        pageSize: Int? = 25,
        start: Int? = 0,
        limit: Int? = 25,
        fields: String? = null,
        populate: String? = null,
        filters: String? = null
    ): Result<StreakResponse> {
        return try {
            val response = streakService.getAllStreaks(sort, withCount, page, pageSize, start, limit, fields, populate, filters)
            if (response.isSuccessful) {
                response.body()?.let {
                    Result.success(it)
                } ?: Result.failure(Exception("No data found"))
            } else {
                Result.failure(Exception("Error: ${response.code()} ${response.message()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Create a new streak
    suspend fun createStreak(request: CreateStreakRequest): Result<StreakResponse> {
        return try {
            val response = streakService.createStreak(request)
            if (response.isSuccessful) {
                response.body()?.let {
                    Result.success(it)
                } ?: Result.failure(Exception("No data found"))
            } else {
                Result.failure(Exception("Error: ${response.code()} ${response.message()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Get a streak by ID
    suspend fun getStreakById(streakId: String): Result<StreakResponse> {
        return try {
            val response = streakService.getStreakById(streakId)
            if (response.isSuccessful) {
                response.body()?.let {
                    Result.success(it)
                } ?: Result.failure(Exception("No data found"))
            } else {
                Result.failure(Exception("Error: ${response.code()} ${response.message()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Update a streak
    suspend fun updateStreak(streakId: Int, request: CreateStreakRequest): Result<StreakResponse> {
        return try {
            val response = streakService.updateStreak(streakId, request)
            if (response.isSuccessful) {
                response.body()?.let {
                    Result.success(it)
                } ?: Result.failure(Exception("No data found"))
            } else {
                Result.failure(Exception("Error: ${response.code()} ${response.message()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Delete a streak
    suspend fun deleteStreak(streakId: Int): Result<Unit> {
        return try {
            val response = streakService.deleteStreak(streakId)
            if (response.isSuccessful) {
                Result.success(Unit)
            } else {
                Result.failure(Exception("Error: ${response.code()} ${response.message()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
