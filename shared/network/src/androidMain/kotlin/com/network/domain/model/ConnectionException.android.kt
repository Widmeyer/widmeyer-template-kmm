package com.network.domain.model

import java.net.UnknownHostException

actual fun Exception.isUnknownHostException() = this is UnknownHostException
