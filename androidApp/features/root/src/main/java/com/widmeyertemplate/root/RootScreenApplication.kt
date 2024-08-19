package com.widmeyertemplate.root

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.os.Bundle
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
    private var currentScreen: AppCompatActivity? = SplashScreen()

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@RootScreenApplication)
            androidLogger(level = Level.DEBUG)
        }

        viewModel = getKoin().get()

        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                if (activity is AppCompatActivity) {
                    currentScreen = activity
                }
            }

            override fun onActivityStarted(activity: Activity) {}
            override fun onActivityResumed(activity: Activity) {
                if (activity is AppCompatActivity) {
                    currentScreen = activity
                }
            }

            override fun onActivityPaused(activity: Activity) {}
            override fun onActivityStopped(activity: Activity) {}
            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
            override fun onActivityDestroyed(activity: Activity) {
                if (currentScreen == activity) {
                    currentScreen = null
                }
            }
        })

        viewModel.screen.addObserver { value ->
            if (value == null) {
                if (viewModel.areThereOtherOpenScreens()) {
                    currentScreen?.finish()
                    viewModel.removeLast()
                }
                return@addObserver
            }

            val newScreen = when (value) {
                Screen.SPLASH -> SplashScreen()
                else -> {
                    Log("RootScreen", "Screen $value not opened")
                    return@addObserver
                }
            }

            val intent = Intent(applicationContext, newScreen::class.java)

            intent.putStringArrayListExtra("arguments", ArrayList(viewModel.arguments))
            intent.putExtra("isClearStack", viewModel.isClearStack)

            if (viewModel.isClearStack) {
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            startActivity(intent)

        }
    }
}