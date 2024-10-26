package com.example.habiboo.domain.use_case.join_room

import com.example.habiboo.domain.repository.RoomsRepository
import retrofit2.Response
import javax.inject.Inject

class JoinRoomUseCase @Inject constructor(
    private val repository: RoomsRepository
) {
    suspend fun execute(roomId: String, password: String?): Response<Void> {
        return repository.joinRoom(roomId, password)
    }
}

