package com.example.habiboo.domain.repository

import com.example.habiboo.domain.model.Task

interface TasksRepository {
    fun getTasksForRoom(roomId: String): List<Task>
    fun completeTask(taskId: String): Unit
}