package com.***.features.screen.presentation

import com.widmeyertemplate.features.base.StateFlow
import com.widmeyertemplate.features.base.ViewModel
class ScreenViewModel(): ViewModel() {
    val errorText: StateFlow<String?> = StateFlow(null)

    init {

    }
}