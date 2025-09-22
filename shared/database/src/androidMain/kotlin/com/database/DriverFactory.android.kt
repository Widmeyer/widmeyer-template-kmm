package com.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import org.koin.java.KoinJavaComponent.getKoin

internal actual fun createDriver(): SqlDriver =
    AndroidSqliteDriver(
        schema = AppDatabase.Schema,
        context = getKoin().get(),
        name = "database.db",
    )