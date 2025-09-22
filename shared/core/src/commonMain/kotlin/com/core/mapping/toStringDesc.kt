package com.core.mapping

import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.StringDesc

fun StringResource.toStringDesc(): StringDesc = StringDesc.Resource(this)