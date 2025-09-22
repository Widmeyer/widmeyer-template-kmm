package com.core.data.infrastructure

import com.core.data.infrastructure.KeyValueStorage

expect class ConfigAppProvider {
    val versionApp: String
    var isFirstLaunch: Boolean
    val keyValueStorage: KeyValueStorage
}