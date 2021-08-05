package ru.test.app.base

data class BaseResponse<T>(
    val content: T? = null,
    val throwable: Throwable? = null,
)
