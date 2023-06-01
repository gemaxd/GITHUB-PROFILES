package com.manarimjesse.githubprofiles.domain.user_detail.repository

import com.manarimjesse.githubprofiles.domain.common.model.GitHubUser
import com.manarimjesse.githubprofiles.domain.common.model.ApiResponse
import com.manarimjesse.githubprofiles.domain.common.model.UserRepo

interface UserDetailRepository {
    suspend fun getUserDetail(query: String): ApiResponse<GitHubUser>
    suspend fun getUserRepos(query: String): ApiResponse<List<UserRepo>>
}