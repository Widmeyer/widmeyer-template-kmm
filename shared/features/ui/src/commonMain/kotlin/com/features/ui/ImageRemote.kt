package com.features.ui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun ImageRemote(
    modifier: Modifier,
    url: String,
    placeHolder: DrawableResource,
    contentScale: ContentScale = ContentScale.Fit,
    contentDescription: String? = null,
) {
    SubcomposeAsyncImage(
        modifier = modifier,
        model = "https://xn--80ahcxihgr.xn--p1ai/assets/promocodes/740f6fe4-6c20-4d1e-91f1-95f404253354.png",
        loading = {
            Image(
                painter = painterResource(placeHolder),
                contentDescription = null
            )
        },
        contentDescription = contentDescription,
        contentScale = contentScale,
        alignment = Alignment.Center,
        filterQuality = FilterQuality.Medium
    )
}