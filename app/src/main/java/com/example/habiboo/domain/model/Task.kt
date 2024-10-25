package com.example.habiboo.domain.model

data class Task(
    val id: String,                // Уникальный идентификатор задачи
    val name: String,              // Название задачи
    val description: String,       // Описание задачи
    val isCompleted: Boolean       // Статус выполнения задачи
)

