package com.manarimjesse.githubprofiles.data.user_list.repository

import com.manarimjesse.githubprofiles.domain.common.model.ApiResponse
import com.manarimjesse.githubprofiles.domain.common.model.GitHubUser
import com.manarimjesse.githubprofiles.domain.common.model.GitHubUsersResponse
import com.manarimjesse.githubprofiles.domain.user_list.remote.UserListService
import com.manarimjesse.githubprofiles.domain.user_list.repository.UserListRepository
import javax.inject.Inject

class UserListRepositoryImpl @Inject constructor(
    private val apiService: UserListService
) : UserListRepository {
    override suspend fun getInitialUserList(): ApiResponse<List<GitHubUser>> {
        return apiService.getInitialUsersList()
    }

    override suspend fun getUserList(query: String): ApiResponse<GitHubUsersResponse> {
        return apiService.getUserList(query = query)
    }
}