package com.widmeyertemplate.ui.theme

import android.content.Context
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.widmeyertemplate.resources.MultiplatformResource

@Composable
fun MainTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = if (isDarkTheme) Colors.Dark(LocalContext.current)
    else Colors.Light(LocalContext.current)

    CompositionLocalProvider(
        localColors(LocalContext.current) provides colors,
        localTypography() provides Typography(font)
    ) {
        MaterialTheme(content = content)
    }
}


private val font = FontFamily(
    Font(
        resId = MultiplatformResource.fonts.regular.fontResourceId,
        weight = FontWeight.Normal
    ),
    Font(
        resId = MultiplatformResource.fonts.regular.fontResourceId,
        weight = FontWeight.Bold
    ),
)

fun localColors(context: Context) = compositionLocalOf<Colors> { Colors.Light(context) }
fun localTypography() = compositionLocalOf { Typography(font) }

object B {
    val colors: Colors
        @Composable get() = localColors(context = LocalContext.current).current

    val typography: Typography
        @Composable get() = localTypography().current
}