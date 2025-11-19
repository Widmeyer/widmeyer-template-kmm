package com.features.splash.presentation.model

sealed interface SplashEffect {
    data object NavigateToMenu: SplashEffect
}