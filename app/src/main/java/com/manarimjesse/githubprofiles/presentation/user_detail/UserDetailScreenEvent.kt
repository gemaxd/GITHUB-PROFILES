package com.manarimjesse.githubprofiles.presentation.user_detail

import com.manarimjesse.githubprofiles.domain.common.model.GitHubUser
import com.manarimjesse.githubprofiles.domain.common.model.UserRepo

sealed class UserDetailScreenEvent{
    data class OnStartLoad(val query: String): UserDetailScreenEvent()
    data class OnStartReposLoad(val query: String): UserDetailScreenEvent()
    data class OnSuccess(val user: GitHubUser): UserDetailScreenEvent()
    data class OnFailure(val exception: Exception): UserDetailScreenEvent()
    data class OnReposFetchSuccess(val repos: List<UserRepo>): UserDetailScreenEvent()
    data class OnReposFetchFailure(val exception: Exception): UserDetailScreenEvent()
}

