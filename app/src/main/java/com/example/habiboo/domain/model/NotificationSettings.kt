package com.example.habiboo.domain.model


data class NotificationSettings(
    val notificationsEnabled: Boolean = false,
    val nonDisabledNotificationsEnabled: Boolean = false,
    val timedNotificationsEnabled: Boolean = false,
    val randomNotificationsEnabled: Boolean = false,
    val timePeriodNotificationsEnabled: Boolean = false,
    val exactTimeNotificationsEnabled: Boolean = false,
    val timePeriod: Int? = null,
    val exactNotificationTime: String? = null
)