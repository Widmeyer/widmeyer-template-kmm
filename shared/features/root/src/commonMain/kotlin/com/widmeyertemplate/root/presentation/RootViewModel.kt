package com.widmeyertemplate.root.presentation

import com.widmeyertemplate.base.features.LiveData
import com.widmeyertemplate.base.features.ViewModel
import com.widmeyertemplate.base.features.enum.Screen

class RootViewModel: ViewModel() {
    val screen: LiveData<Screen?> = LiveData(null)
    private val openScreens: MutableList<Screen> = mutableListOf()
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

        if (isClear) {
            openScreens.clear()
        }

        openScreens.add(screen)

        arguments = argumentsJson
        this.screen.update(screen)
    }

    public fun finishScreen() {
        this.screen.update(null)
    }

    public fun removeLast() {
        openScreens.removeLast()
    }

    fun areThereOtherOpenScreens(): Boolean {
        return openScreens.size > 1
    }
}