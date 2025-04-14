package com.widmeyertemplate.core.data.utils

import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.ResourceFormatted
import dev.icerock.moko.resources.desc.StringDesc

actual fun StringResource.localize() = StringDesc.Resource(this).localized()


actual fun StringResource.format(value: String) = StringDesc.ResourceFormatted(this, value).localized()
