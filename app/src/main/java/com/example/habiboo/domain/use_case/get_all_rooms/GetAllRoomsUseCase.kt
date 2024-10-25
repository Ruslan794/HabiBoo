package com.example.habiboo.domain.use_case.get_all_rooms

import com.example.habiboo.domain.model.Room
import com.example.habiboo.domain.repository.RoomsRepository
import retrofit2.Response

class GetAllRoomsUseCase(private val roomsRepository: RoomsRepository) {
    fun execute(): Response<List<Room>> {
        return roomsRepository.getAllRooms()
    }
}