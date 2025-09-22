package com.features.splash.presentation.model

sealed interface SplashEvents {
    data object OnBack: SplashEvents
    data object OnCloseDialog: SplashEvents
}