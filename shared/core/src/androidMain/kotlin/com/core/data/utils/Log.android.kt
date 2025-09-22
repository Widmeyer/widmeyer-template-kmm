package com.core.data.utils

import android.util.Log
import com.entity.enums.ErrorType

actual fun Log(
    title: String,
    message: String,
    errorType: ErrorType,
) {
    when (errorType) {
        ErrorType.WARNING -> Log.w(title, message)
        ErrorType.ERROR -> Log.e(title, message)
        else -> Log.d(title, message)
    }
}