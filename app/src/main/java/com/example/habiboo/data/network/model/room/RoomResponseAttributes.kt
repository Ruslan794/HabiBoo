package com.example.habiboo.data.network.model.room
import com.example.habiboo.data.network.model.post.PostData
data class RoomResponseAttributes(
    val name: String,
    val description: String?,
    val users: RelatedData<UserData>?,
    val posts: RelatedData<PostData>?,
    val streaks: RelatedData<StreakData>?,
 //   val room_setting: RelatedData<RoomSettingData>?,
    val image: RelatedData<ImageData>?,
    val createdAt: String?,
    val updatedAt: String?
)
