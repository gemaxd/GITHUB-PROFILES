package com.manarimjesse.githubprofiles.data.user_detail.repository

import com.manarimjesse.githubprofiles.domain.common.model.GitHubUser
import com.manarimjesse.githubprofiles.domain.common.model.ApiResponse
import com.manarimjesse.githubprofiles.domain.common.model.UserRepo
import com.manarimjesse.githubprofiles.domain.user_detail.remote.UserDetailService
import com.manarimjesse.githubprofiles.domain.user_detail.repository.UserDetailRepository

class UserDetailRepositoryImpl(
    private val apiService: UserDetailService
): UserDetailRepository {
    override suspend fun getUserDetail(query: String): ApiResponse<GitHubUser> {
        return apiService.getUserDetails(query = query)
    }

    override suspend fun getUserRepos(query: String): ApiResponse<List<UserRepo>> {
        return apiService.getUserRepos(query = query)
    }
}