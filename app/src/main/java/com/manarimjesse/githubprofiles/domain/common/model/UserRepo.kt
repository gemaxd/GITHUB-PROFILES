package com.manarimjesse.githubprofiles.domain.common.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserRepo(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("full_name") val fullName: String,
    @SerialName("private") val private: Boolean
)
