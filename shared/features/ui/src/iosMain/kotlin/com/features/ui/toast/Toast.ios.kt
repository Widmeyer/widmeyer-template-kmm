package com.features.ui.toast

import coil3.PlatformContext
import com.entity.enums.ToastDuration

actual object Toast {
    actual fun showText(
        platformContext: PlatformContext,
        message: String?,
        toastDuration: ToastDuration,
    ) {
        message?.let {
            TODO("Toast make text not implemented")
        }
    }
}