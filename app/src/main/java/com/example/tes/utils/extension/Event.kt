package com.example.crudsample.utils.extension

open class Event<out T>(private val content: T) {

    var eventHandled = false
        private set

    fun getContentIfNotHandled(): T? {
        return if (eventHandled) {
            null
        } else {
            eventHandled = true
            content
        }
    }
}