package com.widmeyertemplate.root.presentation

import com.widmeyertemplate.base.features.domain.StateFlow
import com.widmeyertemplate.base.features.domain.ViewModel
import com.widmeyertemplate.base.features.domain.enum.Screen

class RootViewModel : ViewModel() {
    val screen: StateFlow<Screen?> = StateFlow(null)
    val isPopScreen: StateFlow<Boolean> = StateFlow(false)
    var arguments: List<String> = emptyList()
        private set
    var isClearStack: Boolean = false
        private set

    private val openScreens: MutableList<Screen> = mutableListOf()

    public fun updateScreen(
        screen: Screen,
        argumentsJson: List<String> = emptyList(),
        isClear: Boolean,
    ) {
        val currentScreen = this.screen.getValue()

        if (screen == currentScreen) return

        isClearStack = isClear

        if (isClear) openScreens.clear()

        openScreens.add(screen)

        arguments = argumentsJson
        this@RootViewModel.screen.update(screen)
    }

    public fun finishScreen() {
        screen.update(null)
        isPopScreen.update(true)
    }

    public fun areThereOtherOpenScreens() = openScreens.size > 1
    public fun clearIsPop() {
        isPopScreen.update(false)
    }
}