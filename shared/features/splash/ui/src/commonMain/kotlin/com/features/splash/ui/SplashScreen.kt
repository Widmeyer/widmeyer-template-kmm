package com.features.splash.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import coil3.compose.LocalPlatformContext
import com.core.data.utils.localize
import com.features.base.domain.enum.Screen
import com.features.splash.presentation.model.SplashEvent
import com.features.splash.presentation.SplashViewModel
import com.features.splash.presentation.model.SplashEffect
import com.features.splash.ui.components.SplashScreenContent
import com.features.ui.LoadingContent
import com.features.ui.dialog.DialogError
import com.features.ui.dialog.MainDialog
import com.features.ui.extension.CloseApp
import com.resources.MultiplatformResource
import com.root.presentation.RootViewModel
import com.root.presentation.model.RootEvent
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = koinViewModel(),
    rootViewModel: RootViewModel = koinViewModel(),
) {
    val context = LocalPlatformContext.current
    val state by viewModel.state.collectAsState()

    SplashScreenContent()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                SplashEffect.NavigateToMenu -> rootViewModel.onEvent(
                    RootEvent.OnSetScreen(screen = Screen.MAIN, isClearStack = true)
                )
            }
        }
    }

    when {
        state.isLoading -> LoadingContent()
        state.isNeedUpdate -> MainDialog(
            title = MultiplatformResource.strings.appName.localize(),
            description = MultiplatformResource.strings.appName.localize(),
            confirmText = MultiplatformResource.strings.appName.localize(),
            confirmAction = {
                viewModel.onEvent(SplashEvent.OnClickUpdate)
            },
            cancelText = MultiplatformResource.strings.appName.localize(),
            cancelAction = {
                viewModel.onEvent(SplashEvent.OnCloseDialog)
                CloseApp(context)
            }
        )

        else -> state.error?.let { error ->
            DialogError(
                title = MultiplatformResource.strings.errorTitle.localize(),
                error = error,
                onClose = {
                    viewModel.onEvent(SplashEvent.OnCloseDialog)
                    CloseApp(context)
                }
            )
        }
    }
}
