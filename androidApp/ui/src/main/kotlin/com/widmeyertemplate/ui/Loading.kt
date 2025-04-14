package com.widmeyertemplate.ui

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import com.widmeyertemplate.ui.theme.B

@Composable
fun LoadingContent() {
    CircularProgressIndicator(
        modifier = Modifier.size(22.dp),
        color = B.colors.primary,
        trackColor = B.colors.transparent,
        strokeWidth = 2.dp,
        strokeCap = StrokeCap.Square
    )
}