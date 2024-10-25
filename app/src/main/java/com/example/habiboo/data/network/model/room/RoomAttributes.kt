package com.example.habiboo.data.network.model.room
import com.example.habiboo.data.network.model.post.PostData
import com.example.habiboo.data.network.model.userAuth.User

data class RoomAttributes (
    val name: String,
    val description: String?,
//    val users: RelatedData<UserData>?,
//    val posts: RelatedData<PostData>?,
//    val streaks: RelatedData<StreakData>?,
    val createdAt: String?,
    val updatedAt: String?
)