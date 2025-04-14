package com.widmeyertemplate.root

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.widmeyertemplate.core.data.utils.globalApplicationContext
import org.koin.androidx.compose.KoinAndroidContext
import org.koin.core.annotation.KoinExperimentalAPI

class RootActivity : ComponentActivity() {
    @OptIn(KoinExperimentalAPI::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        globalApplicationContext = applicationContext

        setContent {
            KoinAndroidContext {
                RootApp()
            }
        }
    }
}
