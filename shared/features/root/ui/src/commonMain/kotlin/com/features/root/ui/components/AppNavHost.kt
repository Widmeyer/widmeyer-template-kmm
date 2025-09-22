package com.features.root.ui.components

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil3.compose.setSingletonImageLoaderFactory
import com.features.base.domain.enum.Screen
import com.features.root.ui.components.newImageLoader
import com.features.splash.ui.SplashScreen
import com.features.ui.extension.BackHandler

@Composable
fun AppNavHost(
    navHostController: NavHostController,
    startDestination: Screen = Screen.SPLASH,
) {
    setSingletonImageLoaderFactory { context ->
        newImageLoader(context = context, debug = true)
    }

    NavHost(
        navController = navHostController,
        startDestination = startDestination.name,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        Screen.entries.forEach { screen ->
            composable(screen.name) {
                when (screen) {
                    Screen.SPLASH -> SplashScreen()
                    Screen.AUTHORIZATION -> {
                        //AuthorizationScreen()
                        BackHandler {}
                    }
                    Screen.MAIN -> SplashScreen()//MainScreen()
                }
            }
        }
    }
}

fun NavHostController.handleBackNavigation() {
    val previousRoute = previousBackStackEntry?.destination?.route
    if (previousRoute != null) popBackStack()
    else resetStackAndNavigateTo(Screen.MAIN.name)
}

fun NavHostController.resetStackAndNavigateTo(route: String) = navigate(route) {
    popUpTo(0) {
        inclusive = true
    }
}

fun NavHostController.replaceScreen(oldRoute: String?, newRoute: String) = navigate(newRoute) {
    oldRoute?.let {
        popUpTo(it) {
            inclusive = true
        }
    }
}