package com.database.di

import com.database.AppDatabase
import com.database.createDriver
import com.database.data.repository.UserDatabaseRepositoryImpl
import com.database.domain.repository.UserDatabaseRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val databaseModule = module {
    single<AppDatabase> {
        AppDatabase(createDriver())
    }

    singleOf(::UserDatabaseRepositoryImpl) bind UserDatabaseRepository::class
}