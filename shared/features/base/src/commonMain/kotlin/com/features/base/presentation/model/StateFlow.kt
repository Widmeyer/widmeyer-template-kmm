package com.features.base.presentation.model

import kotlinx.coroutines.flow.MutableStateFlow

class StateFlow<T>(default: T) {
    private val _something: MutableStateFlow<T> = MutableStateFlow(default)
    val state: kotlinx.coroutines.flow.StateFlow<T> = _something

    fun update(value: T) {
        _something.value = value
    }

    operator fun get(index: Int? = null) = state.value
    override operator fun equals(other: Any?): Boolean {
        return when (other) {
            is StateFlow<*> -> other.get() == get()
            else -> other == this
        }
    }
}