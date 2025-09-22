package com.core.data.utils

import com.entity.enums.ErrorType

expect fun Log(title: String, message: String, errorType: ErrorType = ErrorType.DISPLAY)
