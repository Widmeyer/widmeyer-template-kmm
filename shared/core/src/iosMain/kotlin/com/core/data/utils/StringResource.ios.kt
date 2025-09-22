package com.core.data.utils

import coil3.PlatformContext
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.ResourceFormatted
import dev.icerock.moko.resources.desc.StringDesc

actual var globalApplicationContext: PlatformContext? = null
actual fun StringResource.localize() = StringDesc.Resource(this).localized()
actual fun StringResource.format(value: String) =
    StringDesc.ResourceFormatted(this, value).localized()

