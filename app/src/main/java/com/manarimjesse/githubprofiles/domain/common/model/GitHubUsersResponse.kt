package com.manarimjesse.githubprofiles.domain.common.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GitHubUsersResponse(
    @SerialName("total_count") val totalCount: Int? = null,
    @SerialName("incomplete_results") val incompleteResults: Boolean = false,
    @SerialName("items") val items: List<GitHubUser> = emptyList()
)