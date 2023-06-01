package com.manarimjesse.githubprofiles.domain.user_list.remote

import com.manarimjesse.githubprofiles.domain.common.model.ApiResponse
import com.manarimjesse.githubprofiles.domain.common.model.GitHubUser
import com.manarimjesse.githubprofiles.domain.common.model.GitHubUsersResponse

interface UserListService {
    suspend fun getInitialUsersList(): ApiResponse<List<GitHubUser>>
    suspend fun getUserList(query: String): ApiResponse<GitHubUsersResponse>
}