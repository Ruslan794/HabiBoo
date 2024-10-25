package com.example.habiboo.domain.use_case.get_all_rooms

import com.example.habiboo.data.network.model.room.TopRoomsResponse
import com.example.habiboo.domain.repository.RoomsRepository
import retrofit2.Response
import javax.inject.Inject

class GetMyRoomsUseCase @Inject constructor(
    private val roomsRepository: RoomsRepository
) {
    suspend fun execute(): Response<TopRoomsResponse> {
        return roomsRepository.getMyRooms()
    }
}