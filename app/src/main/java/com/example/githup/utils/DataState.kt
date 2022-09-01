package com.example.githup.utils

sealed class DataState<out R> {
    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val errMessage: String? , val throwable: Throwable? = null) : DataState<Nothing>()
    object Loading : DataState<Nothing>()
}
