package com.widmeyertemplate.core.data.infrastructure

import com.russhwolf.settings.Settings
import com.russhwolf.settings.nullableBoolean
import com.russhwolf.settings.nullableString

class KeyValueStorage(private val settings: Settings) {
    var accessToken by settings.nullableString("access_token")
    var refreshToken by settings.nullableString("refresh_token")

    public fun clearTokens() {
        accessToken = null
        refreshToken = null
    }
}
