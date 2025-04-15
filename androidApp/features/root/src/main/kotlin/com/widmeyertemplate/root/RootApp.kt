package com.widmeyertemplate.root

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.widmeyertemplate.base.features.domain.enum.Screen
import com.widmeyertemplate.root.components.LockScreenOrientation
import com.widmeyertemplate.root.presentation.RootViewModel
import com.widmeyertemplate.ui.theme.MainTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun RootApp(
    viewModel: RootViewModel = koinViewModel(),
    navHostController: NavHostController = rememberNavController(),
) {
    val basicNavOption = navOptions {
        popUpTo(Screen.SPLASH.name) {
            inclusive = true
        }
    }

    val screen by viewModel.screen.state.collectAsState()
    val isPopScreen by viewModel.isPopScreen.state.collectAsState()

    LaunchedEffect(screen) {
        if (screen == null) return@LaunchedEffect

        val isClearStack = viewModel.isClearStack

        if (isClearStack) navHostController.resetStackAndNavigateTo(screen?.name.orEmpty())
        else navHostController.navigate(screen?.name.orEmpty(), basicNavOption)
    }

    LaunchedEffect(isPopScreen) {
        if (isPopScreen) {
            navHostController.handleBackNavigation()
            viewModel.clearIsPop()
        }
    }

    LockScreenOrientation()
    MainTheme {
        AppNavHost(navHostController)
        BackHandler { navHostController.handleBackNavigation() }
    }
}