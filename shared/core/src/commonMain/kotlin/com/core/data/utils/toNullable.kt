package com.core.data.utils

import dev.icerock.moko.network.nullable.Nullable

fun String.toNullable(): Nullable<String> {
    return Nullable(value = this)
}