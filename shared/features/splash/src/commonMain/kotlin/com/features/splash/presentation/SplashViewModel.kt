package com.features.splash.presentation

import com.features.base.presentation.model.BaseViewModel
import com.features.base.presentation.model.StateFlow
import com.features.splash.domain.SplashRepository
import com.features.splash.presentation.model.SplashEvents
import com.features.splash.presentation.model.SplashState

class SplashViewModel(private val repository: SplashRepository): BaseViewModel<SplashState, SplashEvents>(SplashState()) {
    val errorText: StateFlow<String?> = StateFlow(null)

    override fun onEvent(events: SplashEvents) = when (events) {
        SplashEvents.OnBack -> {}
        SplashEvents.OnCloseDialog -> clearErrorText()
    }

    private fun clearErrorText() = errorText.update(null)
}