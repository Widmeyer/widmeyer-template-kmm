package com.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver

internal actual fun createDriver(): SqlDriver =
    NativeSqliteDriver(AppDatabase.Schema, "database.db")
