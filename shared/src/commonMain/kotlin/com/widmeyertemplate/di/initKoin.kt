package com.widmeyertemplate.di

import com.widmeyertemplate.root.di.rootModule
import org.koin.dsl.KoinAppDeclaration

public fun startKoin(koinAppDeclaration: KoinAppDeclaration) {
    org.koin.core.context.startKoin {
        koinAppDeclaration()
        modules(listOf(rootModule))
    }
}