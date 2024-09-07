package com.widmeyertemplate.screen.screen

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.widmeyertemplate.features.screen.presentation.ScreenViewModel
import com.widmeyertemplate.root.presentation.RootViewModel
import com.widmeyertemplate.ui.MainTheme
import org.koin.core.parameter.parametersOf
import org.koin.java.KoinJavaComponent.getKoin

@Composable
fun Screen() {
    val context = LocalContext.current
    val activity = context as? ComponentActivity ?: throw IllegalStateException("Context is not an instance of ComponentActivity")

    val viewModel: ScreenViewModel = remember { getKoin().get() }
    val rootViewModel: RootViewModel = remember { getKoin().get() }

    val errorText by viewModel.errorText.state.collectAsState()

    LaunchedEffect(errorText) {
        when {
            errorText != null -> {

            }
        }
    }

    MainTheme {
        ScreenContent()
    }
}