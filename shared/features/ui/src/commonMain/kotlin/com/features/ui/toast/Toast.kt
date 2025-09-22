package com.features.ui.toast

import coil3.PlatformContext
import com.entity.enums.ToastDuration

expect object Toast {
    fun showText(platformContext: PlatformContext, message: String?, toastDuration: ToastDuration)
}