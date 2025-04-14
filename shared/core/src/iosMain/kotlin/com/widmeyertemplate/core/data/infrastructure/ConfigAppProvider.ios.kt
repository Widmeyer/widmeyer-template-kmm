package com.widmeyertemplate.core.data.infrastructure

actual class ConfigAppProvider(actual val keyValueStorage: KeyValueStorage) {
    actual val versionApp: String
        get() = TODO("Not yet implemented")
}