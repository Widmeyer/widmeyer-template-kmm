package com.***.features.screen.presentation

import com.widmeyertemplate.base.features.StateFlow
import com.widmeyertemplate.base.features.ViewModel

class ScreenViewModel(): ViewModel() {
    val errorText: StateFlow<String?> = StateFlow(null)

    init {

    }
}