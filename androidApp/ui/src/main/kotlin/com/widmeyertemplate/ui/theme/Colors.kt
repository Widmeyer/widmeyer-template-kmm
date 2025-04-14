package com.widmeyertemplate.ui.theme
import android.content.Context
import androidx.compose.ui.graphics.Color
import com.widmeyertemplate.resources.MultiplatformResource

sealed class Colors {
	abstract val primary: Color
	abstract val secondary: Color
	abstract val transparent: Color

    data class Light(
        private val context: Context,
		override val primary: Color = Color(MultiplatformResource.colors.primary.getColor(context)),
		override val secondary: Color = Color(MultiplatformResource.colors.secondary.getColor(context)),
		override val transparent: Color = Color(MultiplatformResource.colors.transparent.getColor(context)),
    ): Colors()

    data class Dark(
        private val context: Context, 
		override val primary: Color = Color(MultiplatformResource.colors.primary.getColor(context)),
		override val secondary: Color = Color(MultiplatformResource.colors.secondary.getColor(context)),
		override val transparent: Color = Color(MultiplatformResource.colors.transparent.getColor(context)),
    ): Colors()
}