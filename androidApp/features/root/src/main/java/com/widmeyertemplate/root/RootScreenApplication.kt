package com.widmeyertemplate.root

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.widmeyertemplate.base.features.enum.Screen
import com.widmeyertemplate.data.utils.Log
import com.widmeyertemplate.entity.enums.ErrorType
import com.widmeyertemplate.root.di.startKoin
import com.widmeyertemplate.root.presentation.RootViewModel
import com.widmeyertemplate.screen.splash.SplashScreen
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class RootScreenApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@RootScreenApplication)
            androidLogger(level = Level.DEBUG)
        }

    }
}

class RootActivity : ComponentActivity() {
    private lateinit var viewModel: RootViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = getKoin().get()

        setContent {
            RootApp(viewModel)
        }
    }
}

@Composable
fun RootApp(viewModel: RootViewModel) {
    val navController = rememberNavController()

    val screen by viewModel.screen.state.collectAsState()

    LaunchedEffect(screen) {
        val currentDestination = navController.currentBackStackEntry?.destination?.route
        if (currentDestination != Screen.SPLASH.toString() && screen == null) {
            navController.popBackStack()
            return@LaunchedEffect
        }
        val destination = screen?.toString()

        if (destination == null) {
            Log("RootApp", "Screen $screen not opened", errorType = ErrorType.ERROR)
            return@LaunchedEffect
        }

        if (currentDestination != destination) {
            if (viewModel.isClearStack) {
                navController.navigate(destination) {
                    popUpTo(navController.graph.startDestinationId) {
                        inclusive = true
                    }
                }
            } else {
                navController.navigate(destination)
            }
        }
    }

    NavHost(navController = navController, startDestination = Screen.SPLASH.toString()) {
        composable(Screen.SPLASH.toString()) {
            SplashScreen()
            BackHandler(true) {}
        }
     /*   composable(Screen.AUTHORIZATION.toString()) {
            AuthorizationScreen()
            BackHandler(true) {}
        }
        composable(Screen.MAIN.toString()) {
            MainScreen()
            BackHandler(true) {}
        }*/
    }
}