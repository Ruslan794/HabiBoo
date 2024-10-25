package com.example.habiboo.data.network.model.vote

import com.example.habiboo.data.network.model.room.Meta

data class VoteResponse(
    val data: List<VoteData>,
    val meta: Meta
)
