package com.manarimjesse.githubprofiles.data.user_list.remote

import com.manarimjesse.githubprofiles.domain.common.model.ApiResponse
import com.manarimjesse.githubprofiles.domain.common.model.GitHubUser
import com.manarimjesse.githubprofiles.domain.common.model.GitHubUsersResponse
import com.manarimjesse.githubprofiles.domain.user_list.HttpRoutes
import com.manarimjesse.githubprofiles.domain.user_list.remote.UserListService
import io.ktor.client.HttpClient
import io.ktor.client.features.ClientRequestException
import io.ktor.client.features.RedirectResponseException
import io.ktor.client.features.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.takeFrom
import javax.inject.Inject

class UserListServiceImpl @Inject constructor (
    private val client: HttpClient
): UserListService {
    override suspend fun getInitialUsersList(): ApiResponse<List<GitHubUser>> {
        return try {
            val list: List<GitHubUser> = client.get {
                url(HttpRoutes.USERS_LIST)
            }
            ApiResponse.Success(data = list)
        } catch (e: RedirectResponseException) {
            ApiResponse.Error(exception = e)
        } catch (e: ClientRequestException) {
            ApiResponse.Error(exception = e)
        } catch (e: ServerResponseException) {
            ApiResponse.Error(exception = e)
        } catch (e: Exception) {
            ApiResponse.Error(exception = e)
        }
    }

    override suspend fun getUserList(query: String): ApiResponse<GitHubUsersResponse> {
        return try {
            val list: GitHubUsersResponse = client.get {
                url {
                    takeFrom(HttpRoutes.USERS_LIST_SEARCH)
                    parameters.append("q", query)
                }
            }
            ApiResponse.Success(data = list)
        } catch (e: RedirectResponseException) {
            ApiResponse.Error(exception = e)
        } catch (e: ClientRequestException) {
            ApiResponse.Error(exception = e)
        } catch (e: ServerResponseException) {
            ApiResponse.Error(exception = e)
        } catch (e: Exception) {
            ApiResponse.Error(exception = e)
        }
    }
}