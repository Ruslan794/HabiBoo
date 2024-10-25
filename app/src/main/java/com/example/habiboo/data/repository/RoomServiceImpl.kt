//package com.example.habiboo.data.repository
//
//import com.example.habiboo.data.network.services.RoomService
//
//
//
//import com.example.habiboo.data.network.model.room.*
//import com.example.habiboo.data.network.model.userAuth.User
//import retrofit2.Call
//import retrofit2.Retrofit
//
//class RoomServiceImpl(private val retrofit: Retrofit) {
//    private val roomService: RoomService = retrofit.create(RoomService::class.java)
//
//    fun enterRoom(request: EnterRoomRequest): Call<EnterRoomResponse> {
//        return roomService.enterRoom(request)
//    }
//
//    fun leaveRoom(request: LeaveRoomRequest): Call<LeaveRoomResponse> {
//        return roomService.leaveRoom(request)
//    }
//
//    fun getTopRooms(page: Int = 1, pageSize: Int = 10): Call<TopRoomsResponse> {
//        return roomService.getTopRooms(page, pageSize)
//    }
//
//    fun findUsersByRoom(roomId: String): Call<List<User>> {
//        return roomService.findUsersByRoom(roomId)
//    }
//
//    fun getRooms(
//        sort: String? = null,
//        withCount: Boolean? = true,
//        page: Int? = 0,
//        pageSize: Int? = 25,
//        start: Int? = 0,
//        limit: Int? = 25,
//        fields: String? = null,
//        populate: String? = null,
//        filters: String? = null
//    ): Call<GetRoomsResponse> {
//        return roomService.getRooms(sort, withCount, page, pageSize, start, limit, fields, populate, filters)
//    }
//
//    fun createRoom(request: CreateRoomRequest): Call<CreateRoomResponse> {
//        return roomService.createRoom(request)
//    }
//
//    fun getRoomById(id: Int): Call<GetRoomByIdResponse> {
//        return roomService.getRoomById(id)
//    }
//
//    fun updateRoom(id: Int, request: UpdateRoomRequest): Call<UpdateRoomResponse> {
//        return roomService.updateRoom(id, request)
//    }
//
//    fun deleteRoom(id: Int): Call<Void> {
//        return roomService.deleteRoom(id)
//    }
//}
