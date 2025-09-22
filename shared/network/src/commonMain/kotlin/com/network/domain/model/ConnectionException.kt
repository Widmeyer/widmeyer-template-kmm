package com.network.domain.model

import io.ktor.client.network.sockets.ConnectTimeoutException
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.network.sockets.SocketTimeoutException

fun Exception.isConnectionException() = this is ConnectTimeoutException ||
        this is HttpRequestTimeoutException ||
        this is SocketTimeoutException ||
        isUnknownHostException()

expect fun Exception.isUnknownHostException(): Boolean