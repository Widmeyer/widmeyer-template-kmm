package com.widmeyertemplate.root.di

import com.widmeyertemplate.core.di.coreModule
import com.widmeyertemplate.core.di.platformModule
import com.widmeyertemplate.features.splash.di.splashModule
import com.widmeyertemplate.network.di.networkModule
import org.koin.dsl.KoinAppDeclaration

fun startKoin(koinAppDeclaration: KoinAppDeclaration) {
    org.koin.core.context.startKoin {
        koinAppDeclaration()
        modules(
            rootModule,
            coreModule,
            networkModule,
            platformModule,
            splashModule
		)
    }
}