package com.example.habiboo.domain.model

import java.time.LocalDateTime

data class Habit (
    val id: Int = 0, // will be assigned later by database
    var name: String,
    var note: String,
    val notifications: NotificationSettings,
    val dateOfCreation: LocalDateTime = LocalDateTime.now(),
    val repetitions: List<LocalDateTime> = listOf(),
    var currentStreak: Int = 0,
    var biggestStreak: Int = 0,
    var periodOfBiggestStreak: Pair<LocalDateTime, LocalDateTime>? = null,
    var isDeleted: Boolean = false // when true is actually archived
)