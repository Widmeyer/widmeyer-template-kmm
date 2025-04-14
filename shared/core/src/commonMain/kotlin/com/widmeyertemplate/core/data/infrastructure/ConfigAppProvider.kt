package com.widmeyertemplate.core.data.infrastructure

expect class ConfigAppProvider {
    val versionApp: String
    val keyValueStorage: KeyValueStorage
}