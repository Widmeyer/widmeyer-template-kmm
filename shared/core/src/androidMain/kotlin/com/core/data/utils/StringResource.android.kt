package com.core.data.utils

import coil3.PlatformContext
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.ResourceFormatted
import dev.icerock.moko.resources.desc.StringDesc

actual var globalApplicationContext: PlatformContext? = null
actual fun StringResource.localize(): String {
    return this.getString(context = globalApplicationContext ?: return "")
}

actual fun StringResource.format(value: String): String {
    return StringDesc.ResourceFormatted(this, value)
        .toString(context = globalApplicationContext ?: return "")
}

