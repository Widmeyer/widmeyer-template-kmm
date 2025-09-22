package com.core.di

import com.core.data.infrastructure.ConfigAppProvider
import com.core.data.repositories.CopyRepositoryImpl
import com.core.data.utils.NativeHost
import com.core.domain.repositories.CopyRepository
import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import platform.Foundation.NSUserDefaults

actual val platformModule: Module = module {
    single<Settings> { NSUserDefaultsSettings(NSUserDefaults.standardUserDefaults) }
    singleOf(::NativeHost)
    singleOf(::ConfigAppProvider)
    singleOf(::CopyRepositoryImpl) bind CopyRepository::class
}