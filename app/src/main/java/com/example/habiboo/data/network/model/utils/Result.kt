package com.example.habiboo.data.network.model.utils

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val error: ErrorResponse) : Result<Nothing>()
}
