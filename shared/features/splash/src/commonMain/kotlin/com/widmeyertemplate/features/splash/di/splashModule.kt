package com.widmeyertemplate.features.splash.di

import com.widmeyertemplate.features.splash.data.SplashRepositoryImpl
import com.widmeyertemplate.features.splash.domain.SplashRepository
import com.widmeyertemplate.features.splash.presentation.SplashViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val splashModule: Module = module {
    singleOf(::SplashRepositoryImpl) bind SplashRepository::class
    factoryOf(::SplashViewModel)
}