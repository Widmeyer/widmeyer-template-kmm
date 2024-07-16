package com.widmeyertemplate.base.features

import com.widmeyertemplate.base.features.enum.StateScreen
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class ViewModel(): ViewModel() {
    protected var isInitialized: Boolean = false
        private set

    val stateScreen: LiveData<StateScreen> = LiveData(StateScreen.DEFAULT)

    open fun doInitialize() {
        if (isInitialized) {
            return
        }

        isInitialized = false
    }
    protected fun confirmInitialize() {
        if (isInitialized) {
            return
        }

        isInitialized = true
    }

    public fun updateStateScreen(value: StateScreen) {
        if (value != stateScreen.getValue()) {
            stateScreen.update(value)
        }
    }

    protected suspend fun withContextMain(block: suspend CoroutineScope. () -> Unit) {
        withContext(Dispatchers.Main) {
            block()
        }
    }
}

