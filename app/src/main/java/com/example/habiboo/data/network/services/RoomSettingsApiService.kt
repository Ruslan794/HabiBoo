package com.example.habiboo.data.network.services

import com.example.habiboo.data.network.model.RoomSetting.RoomSettingRequest
import com.example.habiboo.data.network.model.RoomSetting.RoomSettingResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface RoomSettingsApiService {
    @GET("room-settings")
    fun getAllRoomSettings(
        @Query("sort") sort: String? = null,
        @Query("pagination[withCount]") withCount: Boolean? = true,
        @Query("pagination[page]") page: Int? = 0,
        @Query("pagination[pageSize]") pageSize: Int? = 25,
        @Query("pagination[start]") start: Int? = 0,
        @Query("pagination[limit]") limit: Int? = 25,
        @Query("fields") fields: String? = null,
        @Query("populate") populate: String? = null,
        @Query("filters") filters: Map<String, Any>? = null
    ): Call<RoomSettingResponse>


    @GET("room-settings/{id}")
    fun getRoomSettingById(
        @Path("id") id: Int
    ): Call<RoomSettingResponse>

    @POST("room-settings")
    fun createRoomSetting(
        @Body roomSettingRequest: RoomSettingRequest
    ): Call<RoomSettingResponse>

    @PUT("room-settings/{id}")
    fun updateRoomSetting(
        @Path("id") id: Int,
        @Body roomSettingRequest: RoomSettingRequest
    ): Call<RoomSettingResponse>

    @DELETE("room-settings/{id}")
    fun deleteRoomSetting(
        @Path("id") id: Int
    ): Call<RoomSettingResponse>
}