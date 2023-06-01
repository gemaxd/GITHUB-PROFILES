package com.manarimjesse.githubprofiles.domain.user_list.repository

import com.manarimjesse.githubprofiles.domain.common.model.ApiResponse
import com.manarimjesse.githubprofiles.domain.common.model.GitHubUser
import com.manarimjesse.githubprofiles.domain.common.model.GitHubUsersResponse

interface UserListRepository {
    suspend fun getInitialUserList(): ApiResponse<List<GitHubUser>>
    suspend fun getUserList(query: String): ApiResponse<GitHubUsersResponse>
}