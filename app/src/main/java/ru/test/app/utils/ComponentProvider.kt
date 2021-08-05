package ru.test.app.utils

interface ComponentProvider<T> {

    fun provide(): T
}
