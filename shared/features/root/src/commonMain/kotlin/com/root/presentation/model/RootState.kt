package com.root.presentation.model

import com.features.base.domain.enum.Screen
import com.features.base.presentation.model.BaseState

data class RootState(
    val screen: Screen? = null,
    val isPopScreen: Boolean = false,
    var arguments: List<String> = emptyList(),
    var isClearStack: Boolean = false
): BaseState(isLoading = false, errorText = null)