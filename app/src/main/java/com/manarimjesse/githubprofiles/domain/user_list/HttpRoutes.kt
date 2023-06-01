package com.manarimjesse.githubprofiles.domain.user_list

object HttpRoutes {
    private const val BASE_URL = "https://api.github.com"
    const val USERS_LIST = "$BASE_URL/users"
    const val USERS_LIST_SEARCH = "$BASE_URL/search/users"
    const val USER_DETAILS = "$BASE_URL/users/"
}