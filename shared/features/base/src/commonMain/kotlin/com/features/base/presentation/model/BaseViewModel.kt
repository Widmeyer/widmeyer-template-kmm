package com.features.base.presentation.model

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext

abstract class BaseViewModel<S, E>(
    initialState: S,
) : ViewModel() {
    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<S> = _state

    abstract fun onEvent(events: E)
    fun updateState(reducer: (S) -> S) = _state.update { reducer(it) }


    protected suspend fun withContextMain(block: suspend CoroutineScope. () -> Unit) =
        withContext(Dispatchers.Main) {
            block()
        }
}