package com.features.ui.extension

import android.app.Activity
import android.content.Context

actual fun CloseApp(context: Context) {
    (context as? Activity)?.finish()
}
