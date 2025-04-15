package com.widmeyertemplate.base.features.domain

import com.widmeyertemplate.base.features.domain.enum.StateScreen
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class ViewModel() : ViewModel() {
    private val stateScreen: StateFlow<StateScreen> = StateFlow(StateScreen.DEFAULT)
    
    public fun updateStateScreen(value: StateScreen) {
        if (value != stateScreen.getValue()) stateScreen.update(value)
    }

    protected suspend fun withContextMain(block: suspend CoroutineScope. () -> Unit) =
        withContext(Dispatchers.Main) {
            block()
        }
}