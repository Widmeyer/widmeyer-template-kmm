package com.features.root.ui.components

import coil3.ImageLoader
import coil3.PlatformContext
import coil3.memory.MemoryCache
import coil3.request.crossfade
import coil3.util.DebugLogger

fun newImageLoader(
    context: PlatformContext,
    debug: Boolean,
): ImageLoader = ImageLoader.Builder(context)
    .memoryCache {
        MemoryCache.Builder()
            .maxSizePercent(context, percent = 0.25)
            .build()
    }
    .crossfade(true)
    .apply {
        if (debug) {
            logger(DebugLogger())
        }
    }
    .build()
