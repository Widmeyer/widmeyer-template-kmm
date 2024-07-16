package com.widmeyertemplate.data.infrastructure

private external fun apiKey(): String
private external fun prefsName(): String
private external fun url(): String

actual object NativeHost {
    init {
        System.loadLibrary("api-keys")
    }

    actual fun getApiKey(): String {
        return apiKey()
    }

    actual fun getPrefsName(): String {
        return prefsName()
    }

    actual fun getUrl(): String {
        return url()
    }
}