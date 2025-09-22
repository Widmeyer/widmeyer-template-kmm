package com.network.domain.model

import platform.Foundation.NSException
import platform.Foundation.NSURLErrorDomain

actual fun Exception.isUnknownHostException() = (this as? NSException)?.let { exception ->
    exception.name == NSURLErrorDomain
} ?: false