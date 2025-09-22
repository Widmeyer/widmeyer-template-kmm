package com.root.presentation.model

import com.features.base.domain.enum.Screen

sealed interface RootEvents {
    data class OnSetScreen(val screen: Screen, val arguments: List<String> = emptyList(), val isClearStack: Boolean = false): RootEvents
    data object OnClickBack: RootEvents
    data object ClearIsPop: RootEvents
}