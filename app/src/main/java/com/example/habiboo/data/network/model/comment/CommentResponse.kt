package com.example.habiboo.data.network.model.comment

import com.example.habiboo.data.network.model.room.Meta

data class CommentResponse(
    val data: List<CommentData>,
    val meta: Meta
)
