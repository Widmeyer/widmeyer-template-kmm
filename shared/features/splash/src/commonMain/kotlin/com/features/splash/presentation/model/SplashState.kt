package com.features.splash.presentation.model

import com.features.base.domain.model.Error
import com.features.base.presentation.model.BaseState

data class SplashState(
    override val error: Error? = null,
    override val isLoading: Boolean = false,
    val isNeedUpdate: Boolean = false,
    ): BaseState(isLoading = isLoading, error = error)