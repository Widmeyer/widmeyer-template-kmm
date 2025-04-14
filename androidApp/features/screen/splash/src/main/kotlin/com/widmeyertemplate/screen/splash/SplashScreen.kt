package com.widmeyertemplate.screen.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.widmeyertemplate.features.splash.presentation.SplashViewModel
import com.widmeyertemplate.root.presentation.RootViewModel
import com.widmeyertemplate.screen.splash.components.SplashScreenContent
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = koinViewModel(),
    rootViewModel: RootViewModel = koinViewModel(),
) {
    val errorText by viewModel.errorText.state.collectAsState()

    SplashScreenContent()

    if (!errorText.isNullOrEmpty()) {
        // TODO: Dialog
    }
}