package com.widmeyertemplate.data.infrastructure

expect object NativeHost {
    fun getApiKey(): String
    fun getPrefsName(): String
    fun getUrl(): String
}