package com.widmeyertemplate.ui.theme

import androidx.compose.ui.graphics.Color

fun Color.invert(): Color {
    return Color(1f - red, 1f - green, 1f - blue, alpha)
}