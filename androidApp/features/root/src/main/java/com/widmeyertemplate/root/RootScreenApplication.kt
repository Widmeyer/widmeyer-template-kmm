package com.widmeyertemplate.root

import android.app.Application
import android.content.Intent
import android.window.SplashScreen
import com.widmeyertemplate.di.startKoin
import com.widmeyertemplate.root.enum.Screen
import com.widmeyertemplate.root.presentation.RootViewModel
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class RootScreenApplication: Application() {
    private lateinit var viewModel: RootViewModel

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@RootScreenApplication)
            androidLogger(level = Level.DEBUG)
        }

        viewModel = getKoin().get()

        viewModel.screen.addObserver { value ->
            if (value == null) return@addObserver

            val intent = when (value) {
                Screen.SPLASH -> Intent(this, SplashScreen::class.java)
                //Screen.MAIN -> Intent(this, MainActivity::class.java)
                else -> {
                    Log("RootScreen", "Screen $value not opened")
                    return@addObserver
                }
            }

            intent.putStringArrayListExtra("arguments", ArrayList(viewModel.arguments))
            intent.putExtra("isClearStack", viewModel.isClearStack)

            if (viewModel.isClearStack) {
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            startActivity(intent)

        }
    }
}