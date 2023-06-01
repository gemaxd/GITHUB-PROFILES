package com.manarimjesse.githubprofiles.domain.common.model

sealed class ApiResponse<out T> {
    data class Success<T>(val data: T) : ApiResponse<T>()
    data class Error(val exception: Exception) : ApiResponse<Nothing>()
}
