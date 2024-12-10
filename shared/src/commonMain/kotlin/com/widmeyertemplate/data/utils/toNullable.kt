package com.studcenter.domain.utils

import dev.icerock.moko.network.nullable.Nullable

fun String.toNullable(): Nullable<String> {
    return Nullable(value = this)
}