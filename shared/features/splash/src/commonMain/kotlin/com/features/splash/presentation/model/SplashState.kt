package com.features.splash.presentation.model

import com.features.base.presentation.model.BaseState

data class SplashState(
    override val errorText: String? = null
): BaseState(isLoading = false, errorText = errorText)