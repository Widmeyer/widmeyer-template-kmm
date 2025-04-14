package com.widmeyertemplate.core.di

import com.widmeyertemplate.core.data.infrastructure.ConfigAppProvider
import com.widmeyertemplate.core.data.utils.NativeHost
import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import platform.Foundation.NSUserDefaults

actual val platformModule: Module = module {
    singleOf(::NativeHost)
    singleOf(::ConfigAppProvider)

    single<Settings> { NSUserDefaultsSettings(NSUserDefaults.standardUserDefaults) }

}