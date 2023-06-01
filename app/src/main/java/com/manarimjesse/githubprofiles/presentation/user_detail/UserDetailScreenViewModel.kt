package com.manarimjesse.githubprofiles.presentation.user_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manarimjesse.githubprofiles.domain.common.model.ApiResponse
import com.manarimjesse.githubprofiles.domain.user_detail.repository.UserDetailRepository
import com.manarimjesse.githubprofiles.presentation.user_detail.detail_area.UserDetailState
import com.manarimjesse.githubprofiles.presentation.user_detail.repos_area.UserReposListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailScreenViewModel @Inject constructor(
    private val repository: UserDetailRepository
): ViewModel() {
    private val _detailState = mutableStateOf(UserDetailState(query = ""))
    val detailState: State<UserDetailState> = _detailState

    private val _reposState = mutableStateOf(UserReposListState(query = ""))
    val reposState: State<UserReposListState> = _reposState

    fun onEvent(event: UserDetailScreenEvent){
        when(event){
            is UserDetailScreenEvent.OnStartLoad -> {
                viewModelScope.launch {
                    updateUserDetailState {
                        query = event.query
                        isLoading = true
                        hasError = false
                    }
                    loadUserDetails(event.query)
                }
            }
            is UserDetailScreenEvent.OnStartReposLoad -> {
                viewModelScope.launch {
                    updateUserReposState {
                        query = event.query
                        isLoading = true
                        hasError = false
                    }
                    loadReposList(event.query)
                }
            }
            is UserDetailScreenEvent.OnSuccess -> {
                viewModelScope.launch {
                    updateUserDetailState {
                        user = event.user
                        isLoading = false
                        hasError = false
                    }
                }
            }
            is UserDetailScreenEvent.OnReposFetchSuccess -> {
                viewModelScope.launch {
                    updateUserReposState {
                        reposList = event.repos
                        isLoading = false
                        hasError = false
                    }
                }
            }
            is UserDetailScreenEvent.OnFailure -> {
                viewModelScope.launch {
                    updateUserDetailState {
                        exception = event.exception
                        isLoading = false
                        hasError = true
                    }
                }
            }
            is UserDetailScreenEvent.OnReposFetchFailure -> {
                viewModelScope.launch {
                    updateUserReposState {
                        exception = event.exception
                        isLoading = false
                        hasError = true
                    }
                }
            }
        }
    }

    private suspend fun loadUserDetails(query: String) {
        when(val response = repository.getUserDetail(query)){
            is ApiResponse.Success -> {
                onEvent(
                    UserDetailScreenEvent.OnSuccess(
                        user = response.data
                    )
                )
            }
            is ApiResponse.Error -> {
                onEvent(
                    UserDetailScreenEvent.OnFailure(
                        exception = response.exception
                    )
                )
            }
        }
    }

    private suspend fun loadReposList(query: String){
        when(val response = repository.getUserRepos(query)){
            is ApiResponse.Success -> {
                onEvent(
                    UserDetailScreenEvent.OnReposFetchSuccess(
                        repos = response.data
                    )
                )
            }
            is ApiResponse.Error -> {
                onEvent(
                    UserDetailScreenEvent.OnReposFetchFailure(
                        exception = response.exception
                    )
                )
            }
        }
    }

    private fun updateUserDetailState(properties: UserDetailState.() -> Unit) {
        _detailState.value = _detailState.value.copy().apply(properties)
    }

    private fun updateUserReposState(properties: UserReposListState.() -> Unit) {
        _reposState.value = _reposState.value.copy().apply(properties)
    }
}