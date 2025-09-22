package com.features.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import com.features.ui.theme.MainTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun BackgroundContent(
    modifier: Modifier = Modifier,
    isPolygonVisible: Boolean = true,
    alignment: Alignment = Alignment.TopStart,
    backgroundColor: Color = MainTheme.colors.primary,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor),
        contentAlignment = alignment
    ) {
        if (isPolygonVisible) {
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = painterResource(Res.drawable.ic_back),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }

        content()
    }
}

@Preview
@Composable
internal fun BackgroundContent_Preview() {
    MainTheme {
        BackgroundContent {
        }
    }
}
