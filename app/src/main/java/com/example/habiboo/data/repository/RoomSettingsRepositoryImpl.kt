package com.example.habiboo.data.repository

import com.example.habiboo.data.network.model.RoomSetting.RoomSettingRequest
import com.example.habiboo.data.network.model.RoomSetting.RoomSettingResponse
import com.example.habiboo.data.network.services.RoomSettingsApiService
import retrofit2.Call

class RoomSettingsRepositoryImpl(
    private val apiService: RoomSettingsApiService
) : RoomSettingsApiService {

    override fun getAllRoomSettings(
        sort: String?,
        withCount: Boolean?,
        page: Int?,
        pageSize: Int?,
        start: Int?,
        limit: Int?,
        fields: String?,
        populate: String?,
        filters: Map<String, Any>?
    ): Call<RoomSettingResponse> {
        return apiService.getAllRoomSettings(
            sort, withCount, page, pageSize, start, limit, fields, populate, filters
        )
    }

    override fun getRoomSettingById(id: Int): Call<RoomSettingResponse> {
        return apiService.getRoomSettingById(id)
    }

    override fun createRoomSetting(roomSettingRequest: RoomSettingRequest): Call<RoomSettingResponse> {
        return apiService.createRoomSetting(roomSettingRequest)
    }

    override fun updateRoomSetting(id: Int, roomSettingRequest: RoomSettingRequest): Call<RoomSettingResponse> {
        return apiService.updateRoomSetting(id, roomSettingRequest)
    }

    override fun deleteRoomSetting(id: Int): Call<RoomSettingResponse> {
        return apiService.deleteRoomSetting(id)
    }
}
