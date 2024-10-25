package com.example.habiboo.data.network.services

import com.example.habiboo.data.network.model.room.CreateRoomRequest
import com.example.habiboo.data.network.model.room.CreateRoomResponse
import com.example.habiboo.data.network.model.room.EnterRoomRequest
import com.example.habiboo.data.network.model.room.EnterRoomResponse
import com.example.habiboo.data.network.model.room.GetRoomByIdResponse
import com.example.habiboo.data.network.model.room.GetRoomsResponse
import com.example.habiboo.data.network.model.room.LeaveRoomRequest
import com.example.habiboo.data.network.model.room.LeaveRoomResponse
import com.example.habiboo.data.network.model.room.TopRoomsResponse
import com.example.habiboo.data.network.model.room.UpdateRoomRequest
import com.example.habiboo.data.network.model.room.UpdateRoomResponse
import com.example.habiboo.data.network.model.userAuth.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface RoomsApiService {

    @POST("/enterRoom")
    fun enterRoom(@Body request: EnterRoomRequest): Call<EnterRoomResponse>


    @POST("/leaveRoom")
    fun leaveRoom(@Body request: LeaveRoomRequest): Call<LeaveRoomResponse>


    @GET("find-user-room")
    suspend fun getTopRooms(
        @Query("page") page: Int = 1,
        @Query("pageSize") pageSize: Int = 10
    ): Response<TopRoomsResponse>

    @GET("rooms/top-rooms")
    suspend fun getMyRooms(
//        @Header("Authorization") authorization: String,
        @Query("page") page: Int = 1,
        @Query("pageSize") pageSize: Int = 10
    ): Response<TopRoomsResponse>

    @GET("/findUsersByRoom/{roomId}")
    fun findUsersByRoom(@Path("roomId") roomId: String): Call<List<User>>

    @GET("/rooms")
    fun getRooms(
        @Query("sort") sort: String? = null,
        @Query("pagination[withCount]") withCount: Boolean? = true,
        @Query("pagination[page]") page: Int? = 0,
        @Query("pagination[pageSize]") pageSize: Int? = 25,
        @Query("pagination[start]") start: Int? = 0,
        @Query("pagination[limit]") limit: Int? = 25,
        @Query("fields") fields: String? = null,
        @Query("populate") populate: String? = null,
        @Query("filters") filters: String? = null
    ): Call<GetRoomsResponse>

    @POST("/rooms")
    fun createRoom(
        @Body request: CreateRoomRequest
    ): Call<CreateRoomResponse>

    @GET("/rooms/{id}")
    fun getRoomById(
        @Path("id") id: Int
    ): Call<GetRoomByIdResponse>

    @PUT("/rooms/{id}")
    fun updateRoom(
        @Path("id") id: Int,
        @Body request: UpdateRoomRequest
    ): Call<UpdateRoomResponse>

    @DELETE("/rooms/{id}")
    fun deleteRoom(
        @Path("id") id: Int
    ): Call<Void> // Use Void because the successful response is an empty body

}
