package com.features.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

@Immutable
data class Typography(private val font: FontFamily) {
    val main: TitleTypography =
        TitleTypography(font)
    val dialog: DialogTypography =
        DialogTypography(font)
}

@Immutable
data class TitleTypography(private val font: FontFamily) {
    val title: TextStyle = TextStyle(
        fontSize = 20.sp,
        lineHeight = 28.sp,
        fontFamily = font,
        fontWeight = FontWeight.W600
    ).preciseLineHeight()

    val main: TextStyle = TextStyle(
        fontSize = 14.sp,
        lineHeight = 28.sp,
        fontFamily = font,
        fontWeight = FontWeight.W400
    ).preciseLineHeight()

    val buttonText: TextStyle = TextStyle(
        fontSize = 16.sp,
        lineHeight = 22.sp,
        fontFamily = font,
        fontWeight = FontWeight.W600,
    )

    val secondButtonText: TextStyle = TextStyle(
        fontSize = 16.sp,
        lineHeight = 22.sp,
        fontFamily = font,
        fontWeight = FontWeight.W400,
    )

    val inputText: TextStyle = TextStyle(
        fontSize = 14.sp,
        lineHeight = 28.sp,
        fontFamily = font,
        fontWeight = FontWeight.W400
    ).preciseLineHeight()

    val disabledTextField: TextStyle = TextStyle(
        fontSize = 14.sp,
        lineHeight = 22.sp,
        fontFamily = font,
        fontWeight = FontWeight.W400
    ).preciseLineHeight()

    val hintText: TextStyle = TextStyle(
        fontSize = 14.sp,
        lineHeight = 28.sp,
        fontFamily = font,
        fontWeight = FontWeight.W400
    ).preciseLineHeight()

    val lowText: TextStyle = TextStyle(
        fontSize = 12.sp,
        lineHeight = 20.sp,
        fontFamily = font,
        fontWeight = FontWeight.W400
    ).preciseLineHeight()

    val underline: TextStyle = TextStyle(
        fontSize = 16.sp,
        lineHeight = 28.sp,
        fontFamily = font,
        fontWeight = FontWeight.W400,
        textDecoration = TextDecoration.Underline
    ).preciseLineHeight()

    val coin: TextStyle = TextStyle(
        fontSize = 16.sp,
        lineHeight = 12.sp,
        fontFamily = font,
        fontWeight = FontWeight.W600,
    ).preciseLineHeight()
}

@Immutable
data class DialogTypography(private val font: FontFamily) {
    val title: TextStyle = TextStyle(
        fontSize = 20.sp,
        lineHeight = 28.sp,
        fontFamily = font,
        fontWeight = FontWeight.W600
    ).preciseLineHeight()

    val main: TextStyle = TextStyle(
        fontSize = 16.sp,
        lineHeight = 28.sp,
        fontFamily = font,
        fontWeight = FontWeight.W400
    ).preciseLineHeight()

    val buttonText: TextStyle = TextStyle(
        fontSize = 14.sp,
        lineHeight = 22.sp,
        fontFamily = font,
        fontWeight = FontWeight.W400,
    )
}


expect fun TextStyle.preciseLineHeight(): TextStyle