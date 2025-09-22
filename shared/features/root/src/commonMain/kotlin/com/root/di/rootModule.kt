package com.root.di

import com.root.presentation.RootViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val rootModule: Module = module {
    singleOf(::RootViewModel)
}