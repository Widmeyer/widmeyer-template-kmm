package com.widmeyertemplate.features.splash.presentation

import com.widmeyertemplate.base.features.StateFlow
import com.widmeyertemplate.base.features.ViewModel
import com.widmeyertemplate.data.model.ConfigParams


class SplashViewModel(val configParams: ConfigParams): ViewModel() {
    val errorText: StateFlow<String?> = StateFlow(null)
}