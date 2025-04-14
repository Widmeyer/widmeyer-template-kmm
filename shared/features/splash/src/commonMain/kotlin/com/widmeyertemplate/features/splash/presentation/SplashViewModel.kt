package com.widmeyertemplate.features.splash.presentation

import com.widmeyertemplate.base.features.domain.StateFlow
import com.widmeyertemplate.base.features.domain.ViewModel
import com.widmeyertemplate.features.splash.domain.SplashRepository

class SplashViewModel(private val splashRepository: SplashRepository): ViewModel() {
    val errorText: StateFlow<String?> = StateFlow(null)

    public fun clearErrorText() {
        errorText.update(null)
    }
}