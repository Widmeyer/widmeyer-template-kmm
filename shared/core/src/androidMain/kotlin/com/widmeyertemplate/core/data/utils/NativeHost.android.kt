package com.widmeyertemplate.core.data.utils

import com.widmeyertemplate.core.BuildConfig
import com.widmeyertemplate.core.data.model.BuildVariant

private external fun url(): String

actual class NativeHost {
    init {
        val type = BuildConfig.BUILD_TYPE
        val libName = BuildVariant.valueOf(type).buildType
        System.loadLibrary(libName)
    }

    actual fun getUrl() = url()
}