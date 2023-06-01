package com.manarimjesse.githubprofiles.presentation.user_detail.repos_area

import com.manarimjesse.githubprofiles.domain.common.model.UserRepo
import java.lang.Exception

data class UserReposListState(
    var query: String,
    var reposList: List<UserRepo> = emptyList(),
    var isLoading: Boolean = false,
    var hasError: Boolean = false,
    var exception: Exception? = null
)
