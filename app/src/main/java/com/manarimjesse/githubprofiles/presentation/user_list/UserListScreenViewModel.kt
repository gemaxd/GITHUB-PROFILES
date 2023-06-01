package com.manarimjesse.githubprofiles.presentation.user_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manarimjesse.githubprofiles.domain.common.model.ApiResponse
import com.manarimjesse.githubprofiles.domain.user_list.repository.UserListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListScreenViewModel @Inject constructor(
    private val repository: UserListRepository
): ViewModel() {
    private val _state = mutableStateOf(UserListScreenState())
    val state: State<UserListScreenState> = _state

    fun onEvent(event: UserListScreenEvent){
        when(event){
            is UserListScreenEvent.OnStartLoad -> {
                viewModelScope.launch {
                    updateUserLisState {
                        isLoading = true
                        hasError = false
                    }
                    loadInitialUserList()
                }
            }
            is UserListScreenEvent.OnFetchUsers -> {
                viewModelScope.launch {
                    updateUserLisState {
                        isLoading = true
                        hasError = false
                    }
                    loadUserList(event.query)
                }
            }
            is UserListScreenEvent.OnSuccess -> {
                viewModelScope.launch {
                    updateUserLisState {
                        userList = event.users
                        isLoading = false
                        hasError = false
                    }
                }
            }
            is UserListScreenEvent.OnFailure -> {
                viewModelScope.launch {
                    updateUserLisState {
                        exception = event.exception
                        isLoading = false
                        hasError = true
                    }
                }
            }
        }
    }

    private suspend fun loadUserList(query: String){
        when(val apiResponse = repository.getUserList(query = query)){
            is ApiResponse.Success -> {
                onEvent(
                    UserListScreenEvent.OnSuccess(
                        users = apiResponse.data.items
                    )
                )
            }
            is ApiResponse.Error -> {
                onEvent(
                    UserListScreenEvent.OnFailure(
                        exception = apiResponse.exception
                    )
                )
            }
        }
    }

    private suspend fun loadInitialUserList() {
        when(val apiResponse = repository.getInitialUserList()){
            is ApiResponse.Success -> {
                onEvent(
                    UserListScreenEvent.OnSuccess(
                        users = apiResponse.data
                    )
                )
            }
            is ApiResponse.Error -> {
                onEvent(
                    UserListScreenEvent.OnFailure(
                        exception = apiResponse.exception
                    )
                )
            }
        }
    }

    private fun updateUserLisState(properties: UserListScreenState.() -> Unit) {
        _state.value = _state.value.copy().apply(properties)
    }
}