package com.widmeyertemplate.root.di

import com.widmeyertemplate.di.networkModule
import com.widmeyertemplate.features.splash.di.splashModule
import org.koin.dsl.KoinAppDeclaration

public fun startKoin(koinAppDeclaration: KoinAppDeclaration) {
    org.koin.core.context.startKoin {
        koinAppDeclaration()
        modules(rootModule, networkModule, splashModule)
    }
}