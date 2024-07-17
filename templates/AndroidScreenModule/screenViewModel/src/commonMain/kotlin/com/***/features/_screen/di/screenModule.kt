package com.deliveryms.features.screen.di

import com.deliveryms.features.splash.presentation.SplashViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val screenModule: Module = module {
    factory {
        ScreenViewModel()
    }
}