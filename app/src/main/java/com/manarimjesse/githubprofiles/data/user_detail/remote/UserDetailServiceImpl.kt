package com.manarimjesse.githubprofiles.data.user_detail.remote

import com.manarimjesse.githubprofiles.domain.common.model.GitHubUser
import com.manarimjesse.githubprofiles.domain.common.model.ApiResponse
import com.manarimjesse.githubprofiles.domain.common.model.UserRepo
import com.manarimjesse.githubprofiles.domain.user_detail.remote.UserDetailService
import com.manarimjesse.githubprofiles.domain.user_list.HttpRoutes
import io.ktor.client.HttpClient
import io.ktor.client.features.ClientRequestException
import io.ktor.client.features.RedirectResponseException
import io.ktor.client.features.ServerResponseException
import io.ktor.client.request.get
import io.ktor.http.takeFrom
import javax.inject.Inject

class UserDetailServiceImpl @Inject constructor (
    private val client: HttpClient
): UserDetailService {
    override suspend fun getUserDetails(query: String): ApiResponse<GitHubUser> {
        return try {
            val user : GitHubUser = client.get {
                url {
                    takeFrom("${HttpRoutes.USER_DETAILS}$query")
                }
            }
            ApiResponse.Success(user)
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

    override suspend fun getUserRepos(query: String): ApiResponse<List<UserRepo>> {
        return try {
            val repos : List<UserRepo> = client.get {
                url {
                    takeFrom("${HttpRoutes.USER_DETAILS}$query/repos")
                }
            }
            ApiResponse.Success(repos)
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