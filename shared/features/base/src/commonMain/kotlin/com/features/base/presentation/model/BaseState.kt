package com.features.base.presentation.model

open class BaseState(
    open val isLoading: Boolean,
    open val errorText: String?
)