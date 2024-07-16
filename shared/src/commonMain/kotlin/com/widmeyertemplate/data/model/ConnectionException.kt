package com.widmeyertemplate.data.model

import com.widmeyertemplate.domain.constants.Constants
import io.ktor.client.network.sockets.ConnectTimeoutException
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.network.sockets.SocketTimeoutException

class ConnectionException: Throwable(message = Constants.Strings.errorConnection)

fun isConnectionException(e: Throwable): Boolean {
    return when (e) {
        is ConnectTimeoutException,
        is HttpRequestTimeoutException,
        is SocketTimeoutException,
        is ConnectionException
        -> true
        else -> false
    }
}