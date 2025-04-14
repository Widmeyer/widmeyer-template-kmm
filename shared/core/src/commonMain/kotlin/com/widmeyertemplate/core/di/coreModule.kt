package com.widmeyertemplate.core.di

import com.widmeyertemplate.core.data.infrastructure.KeyValueStorage
import com.widmeyertemplate.core.data.model.ConfigParams
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


@Suppress("LongMethod")
val coreModule: Module = module {
    singleOf(::KeyValueStorage)
    singleOf(::ConfigParams)
}