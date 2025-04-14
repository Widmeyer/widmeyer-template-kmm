package com.widmeyertemplate.screen.splash.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.widmeyertemplate.core.data.utils.globalApplicationContext
import com.widmeyertemplate.core.data.utils.localize
import com.widmeyertemplate.resources.MultiplatformResource
import com.widmeyertemplate.ui.theme.B
import com.widmeyertemplate.ui.theme.MainTheme

@Composable
internal fun SplashScreenContent() {
    Scaffold { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = MultiplatformResource.strings.appName.localize(),
                color = B.colors.primary
            )
        }
    }
}

@Composable
@Preview
internal fun SplashScreenContent_Preview() {
    globalApplicationContext = LocalContext.current

    MainTheme {
        SplashScreenContent()
    }
}