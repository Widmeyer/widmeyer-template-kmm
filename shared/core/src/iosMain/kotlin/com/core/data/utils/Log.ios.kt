package com.core.data.utils

import com.entity.enums.ErrorType

actual fun Log(
    title: String,
    message: String,
    errorType: ErrorType,
) {
    val errorTypeMessage = when (errorType) {
        ErrorType.DISPLAY -> "(DISPLAY)"
        ErrorType.ERROR -> "(ERROR)"
        ErrorType.WARNING -> "(WARNING)"
    }

    print("$errorTypeMessage\n$title: $message")
}