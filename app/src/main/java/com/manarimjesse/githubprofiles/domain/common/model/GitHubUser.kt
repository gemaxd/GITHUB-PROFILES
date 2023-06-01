package com.manarimjesse.githubprofiles.domain.common.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GitHubUser(
    @SerialName("login") val login: String? = null,
    @SerialName("id") val id: Int? = null,
    @SerialName("avatar_url") val avatarUrl: String? = null,
    @SerialName("html_url") val htmlUrl: String? = null
)