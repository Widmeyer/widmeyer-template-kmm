package com.widmeyertemplate.root.di

import com.widmeyertemplate.root.presentation.RootViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val rootModule: Module = module {
    singleOf(::RootViewModel)
}