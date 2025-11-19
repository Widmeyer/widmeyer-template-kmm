package com.features.splash.presentation.model

sealed interface SplashEvent {
    data object OnCloseDialog: SplashEvent
    data object OnClickUpdate: SplashEvent
}