package com.manarimjesse.githubprofiles.presentation.user_list

import com.manarimjesse.githubprofiles.domain.common.model.GitHubUser

data class UserListScreenState(
    var userList: List<GitHubUser> = emptyList(),
    var isLoading: Boolean = false,
    var hasError: Boolean = false,
    var exception: Exception? = null
)
