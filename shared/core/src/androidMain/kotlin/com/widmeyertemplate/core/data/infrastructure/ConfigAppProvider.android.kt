package com.widmeyertemplate.core.data.infrastructure

import com.widmeyertemplate.core.BuildConfig

actual class ConfigAppProvider(actual val keyValueStorage: KeyValueStorage) {
    actual val versionApp: String = BuildConfig.VERSION_NAME
}