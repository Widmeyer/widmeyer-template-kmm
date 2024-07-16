package com.widmeyertemplate.data.infrastructure

actual class ConfigAppProvider(actual val keyValueStorage: KeyValueStorage) {
    actual val brandId: Int
        get() = TODO("Not yet implemented")
    actual val versionApp: String
        get() = TODO("Not yet implemented")
    actual var isFirstLaunch: Boolean = keyValueStorage.firstLaunch.let { true }
    actual var basePath: String = NativeHost.getApiKey()
}