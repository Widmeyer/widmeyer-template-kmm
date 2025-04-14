package com.widmeyertemplate.core.data.utils

import com.widmeyertemplate.entity.enums.ErrorType

expect fun Log(title: String, message: String, errorType: ErrorType = ErrorType.DISPLAY)
