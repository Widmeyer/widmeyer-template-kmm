package com.core.data.infrastructure

import com.core.BuildConfig


actual class ConfigAppProvider(actual val keyValueStorage: KeyValueStorage) {
    actual val versionApp: String = BuildConfig.VERSION_NAME
    actual var isFirstLaunch: Boolean = keyValueStorage.firstLaunch.let { true }
}