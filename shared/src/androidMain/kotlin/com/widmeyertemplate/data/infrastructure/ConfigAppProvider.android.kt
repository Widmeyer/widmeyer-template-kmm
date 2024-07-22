package com.widmeyertemplate.data.infrastructure

import com.widmeyertemplate.BuildConfig


actual class ConfigAppProvider(actual val keyValueStorage: KeyValueStorage) {
    actual val versionApp: String
        get() = BuildConfig.VERSION_NAME
    actual var isFirstLaunch: Boolean = keyValueStorage.firstLaunch.let { true }
    actual var basePath: String = NativeHost.getApiKey()
}