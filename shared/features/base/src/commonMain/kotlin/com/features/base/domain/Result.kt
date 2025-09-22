package com.features.base.domain

sealed interface Result<out T, out Y> {
    data class Success<T>(val data: T): Result<T, Nothing>
    data class Failure<Y>(val error: Y): Result<Nothing, Y>
    data object Loading: Result<Nothing, Nothing>
    data object TokenExpired: Result<Nothing, Nothing>
    data object ConnectionError: Result<Nothing, Nothing>
}