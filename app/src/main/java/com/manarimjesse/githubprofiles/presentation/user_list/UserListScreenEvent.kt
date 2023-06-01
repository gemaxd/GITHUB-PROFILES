package com.manarimjesse.githubprofiles.presentation.user_list

import com.manarimjesse.githubprofiles.domain.common.model.GitHubUser

sealed class UserListScreenEvent {
    object OnStartLoad: UserListScreenEvent()
    data class OnFetchUsers(val query: String): UserListScreenEvent()
    data class OnSuccess(val users: List<GitHubUser>): UserListScreenEvent()
    data class OnFailure(val exception: Exception): UserListScreenEvent()
}