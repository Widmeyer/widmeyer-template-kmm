package com.widmeyertemplate.features.splash.di

import com.widmeyertemplate.features.splash.presentation.SplashViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val splashModule: Module = module {
    factory {
        SplashViewModel(
            configParams = get(),
        )
    }
}