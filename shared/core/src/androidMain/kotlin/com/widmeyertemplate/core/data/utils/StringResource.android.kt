package com.widmeyertemplate.core.data.utils

import android.content.Context
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.ResourceFormatted
import dev.icerock.moko.resources.desc.StringDesc

var globalApplicationContext: Context? = null

actual fun StringResource.localize(): String {
    return this.getString(context = globalApplicationContext ?: return "")
}

actual fun StringResource.format(value: String): String {
    return StringDesc.ResourceFormatted(this, value)
        .toString(context = globalApplicationContext ?: return "")
}