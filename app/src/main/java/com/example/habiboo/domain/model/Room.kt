package com.example.habiboo.domain.model

data class Room(
    val id: String,                // Уникальный идентификатор комнаты
    val name: String,              // Название комнаты
    val description: String,       // Описание комнаты
    val maxMembers: Int,           // Максимальное количество участников в комнате
    val currentMembers: Int,       // Текущее количество участников в комнате
    val isPrivate: Boolean,        // Приватная комната или нет
    val imageUrl: String?,         // URL изображения, связанного с комнатой (если есть)
    val tasks: List<Task>          // Список задач, связанных с комнатой
)

