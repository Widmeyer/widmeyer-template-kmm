package com.features.splash.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import com.features.ui.Res
import com.features.ui.appName
import com.features.ui.ic_back
import com.features.ui.theme.MainTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
internal fun SplashScreenContent() {
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .scale(0.8f)
                    .padding(bottom = 0.dp),
                painter = painterResource(Res.drawable.ic_back),
                contentDescription = null,
            )

            Text(
                text = stringResource(Res.string.appName),
                style = MainTheme.typography.main.title,
                color = MainTheme.colors.secondary,
            )
        }
    }
}

@Composable
@Preview
internal fun SplashScreenContent_Preview() {
    MainTheme {
        SplashScreenContent()
    }
}