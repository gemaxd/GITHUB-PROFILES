package com.manarimjesse.githubprofiles.presentation.user_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.manarimjesse.githubprofiles.R
import com.manarimjesse.githubprofiles.domain.common.model.GitHubUser
import com.manarimjesse.githubprofiles.presentation.common.components.GitHubProfilesTopBar
import com.manarimjesse.githubprofiles.presentation.common.components.InputSearch
import com.manarimjesse.githubprofiles.presentation.common.content.ErrorContent
import com.manarimjesse.githubprofiles.presentation.common.content.LoadingContent
import com.manarimjesse.githubprofiles.ui.theme.Black

@ExperimentalMaterial3Api
@ExperimentalCoilApi
@Composable
fun UserListScreen(
    navController: NavHostController? = null,
    state: UserListScreenState,
    onEvent: (UserListScreenEvent) -> Unit
) {
    LaunchedEffect(Unit) {
        onEvent(UserListScreenEvent.OnStartLoad)
    }

    Scaffold(
        topBar = {
            GitHubProfilesTopBar(
                title = stringResource(R.string.github_profiles)
            )
        }
    ){ innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            UserScreeListContainer(
                navController = navController,
                state = state,
                onEvent = onEvent
            )
        }
    }
}

@ExperimentalCoilApi
@ExperimentalMaterial3Api
@Composable
fun UserScreeListContainer(
    navController: NavHostController?,
    state: UserListScreenState,
    onEvent: (UserListScreenEvent) -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            InputSearch(
                onEvent = { query ->
                    onEvent(UserListScreenEvent.OnFetchUsers(query = query))
                }
            )
            if(state.isLoading){
                LoadingContent()
            } else if (state.hasError) {
                ErrorContent(
                    contextMessage = stringResource(R.string.context_user_list),
                    exception = state.exception,
                    onRetry = {
                        onEvent(UserListScreenEvent.OnStartLoad)
                    }
                )
            } else {
                UserScreeListContent(
                    navController = navController,
                    state = state
                )
            }
        }
    }
}

@ExperimentalCoilApi
@ExperimentalMaterial3Api
@Composable
@Preview(showBackground = true)
fun PreviewUserListScreen(){
    UserListScreen(
        state = UserListScreenState(
            userList = listOf(
                GitHubUser(
                    id = 1,
                    login = "shauhsuahs",
                    avatarUrl = "shauhsuahs",
                    htmlUrl = "shuahsuahusha"
                ),
                GitHubUser(
                    id = 1,
                    login = "shauhsuahs",
                    avatarUrl = "shauhsuahs",
                    htmlUrl = "shuahsuahusha"
                ),
                GitHubUser(
                    id = 1,
                    login = "shauhsuahs",
                    avatarUrl = "shauhsuahs",
                    htmlUrl = "shuahsuahusha"
                ),GitHubUser(
                    id = 1,
                    login = "shauhsuahs",
                    avatarUrl = "shauhsuahs",
                    htmlUrl = "shuahsuahusha"
                )
            ),
            isLoading = false
        ),
        onEvent = {}
    )
}

