package com.widmeyertemplate.root.di

import com.widmeyertemplate.data.infrastructure.ConfigAppProvider
import com.widmeyertemplate.data.model.ConfigParams
import com.widmeyertemplate.root.presentation.RootViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val rootModule: Module = module {
    singleOf(::KeyValueStorage)

    single { ConfigAppProvider(keyValueStorage = get()) }
    single { ConfigParams(keyValueStorage = get(), configAppProvider = get()) }

    single {
        RootViewModel()
    }

}