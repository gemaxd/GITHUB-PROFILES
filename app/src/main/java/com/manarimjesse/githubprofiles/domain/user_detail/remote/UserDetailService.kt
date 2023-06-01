package com.manarimjesse.githubprofiles.domain.user_detail.remote

import com.manarimjesse.githubprofiles.domain.common.model.GitHubUser
import com.manarimjesse.githubprofiles.domain.common.model.ApiResponse
import com.manarimjesse.githubprofiles.domain.common.model.UserRepo

interface UserDetailService {
    suspend fun getUserDetails(query: String): ApiResponse<GitHubUser>
    suspend fun getUserRepos(query: String): ApiResponse<List<UserRepo>>
}