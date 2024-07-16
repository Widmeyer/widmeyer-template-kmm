package com.widmeyertemplate.root.presentation

import com.widmeyertemplate.base.LiveData
import com.widmeyertemplate.base.ViewModel
import com.widmeyertemplate.root.enum.Screen

class RootViewModel: ViewModel() {
    val screen: LiveData<Screen?> = LiveData(null)
    var arguments: List<String> = emptyList()
        private set
    var isClearStack: Boolean = false
        private set

    public fun updateScreen(screen: Screen, argumentsJson: List<String> = emptyList(), isClear: Boolean) {
        val currentScreen = this.screen.getValue()

        if (screen == currentScreen) {
            return
        }

        isClearStack = isClear
        arguments = argumentsJson
        this.screen.update(screen)
    }
}