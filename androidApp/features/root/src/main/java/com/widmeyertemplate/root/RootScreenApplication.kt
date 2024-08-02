package com.widmeyertemplate.root

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.widmeyertemplate.base.features.enum.Screen
import com.widmeyertemplate.data.utils.Log
import com.widmeyertemplate.root.di.startKoin
import com.widmeyertemplate.root.presentation.RootViewModel
import com.widmeyertemplate.screen.splash.SplashScreen
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class RootScreenApplication: Application() {
    private lateinit var viewModel: RootViewModel
    private var currentScreen: AppCompatActivity = SplashScreen()

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@RootScreenApplication)
            androidLogger(level = Level.DEBUG)
        }

        viewModel = getKoin().get()

        viewModel.screen.addObserver { value ->
            if (value == null) {
                if (viewModel.areThereOtherOpenScreens()) {
                    currentScreen.finish()
                    viewModel.removeLast()
                }
                return@addObserver
            }

            currentScreen = when (value) {
                Screen.SPLASH -> SplashScreen()
                else -> {
                    Log("RootScreen", "Screen $value not opened")
                    return@addObserver
                }
            }

            val intent = Intent(applicationContext, currentScreen::class.java)

            intent.putStringArrayListExtra("arguments", ArrayList(viewModel.arguments))
            intent.putExtra("isClearStack", viewModel.isClearStack)

            if (viewModel.isClearStack) {
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            startActivity(intent)

        }
    }
}