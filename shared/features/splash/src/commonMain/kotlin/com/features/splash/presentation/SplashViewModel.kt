package com.features.splash.presentation

import com.features.base.presentation.model.BaseViewModel
import com.features.splash.domain.SplashRepository
import com.features.splash.presentation.model.SplashEffect
import com.features.splash.presentation.model.SplashEvent
import com.features.splash.presentation.model.SplashState
import kotlinx.coroutines.launch


class SplashViewModel(
    private val repository: SplashRepository,
) :
    BaseViewModel<SplashState, SplashEvent, SplashEffect>(SplashState()) {
    init {
        initialize()
    }

    override fun onEvent(event: SplashEvent) {
        when (event) {
            SplashEvent.OnCloseDialog -> updateState { it.copy(error = null) }
            SplashEvent.OnClickUpdate -> downloadFile()
        }
    }

    private fun initialize() = viewModelScope.launch {
    }

    private fun downloadFile() = viewModelScope.launch {
        updateState { it.copy(isNeedUpdate = false, isLoading = true) }
    }
}