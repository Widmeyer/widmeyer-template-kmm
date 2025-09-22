package com.database.data.adapter

import app.cash.sqldelight.ColumnAdapter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

inline fun <reified T : Any> adapter() = object : ColumnAdapter<T, String> {
    override fun decode(databaseValue: String) = Json.decodeFromString<T>(databaseValue)
    override fun encode(value: T) = Json.encodeToString(value)
}