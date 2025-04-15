package com.widmeyertemplate.base.features.domain

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class StateFlow<T>(default: T) {
    private val _something: MutableStateFlow<T> = MutableStateFlow(default)
    val state: StateFlow<T> = _something

    fun update(value: T) {
        _something.value = value
    }

    fun getValue() = state.value
}