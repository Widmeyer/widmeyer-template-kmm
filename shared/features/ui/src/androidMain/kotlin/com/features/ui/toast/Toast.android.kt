package com.features.ui.toast

import android.widget.Toast
import coil3.PlatformContext
import com.entity.enums.ToastDuration

actual object Toast {
    actual fun showText(
        platformContext: PlatformContext,
        message: String?,
        toastDuration: ToastDuration,
    ) {
        message?.let {
            val duration = when (toastDuration) {
                ToastDuration.SHORT -> Toast.LENGTH_SHORT
                ToastDuration.LONG -> Toast.LENGTH_LONG
            }
            Toast.makeText(platformContext, it, duration).show()
        }
    }
}