package com.widmeyertemplate.data.infrastructure

expect class ConfigAppProvider {
    val brandId: Int
    val versionApp: String
    var isFirstLaunch: Boolean
    val keyValueStorage: KeyValueStorage
    var basePath: String
}