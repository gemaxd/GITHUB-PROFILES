package com.manarimjesse.githubprofiles.presentation.user_detail.detail_area

import com.manarimjesse.githubprofiles.domain.common.model.GitHubUser
import java.lang.Exception

data class UserDetailState(
    var query: String,
    var user: GitHubUser = GitHubUser(),
    var isLoading: Boolean = false,
    var hasError: Boolean = false,
    var exception: Exception? = null
)
