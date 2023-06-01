package com.manarimjesse.githubprofiles.presentation.user_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.manarimjesse.githubprofiles.R
import com.manarimjesse.githubprofiles.presentation.common.components.GitHubProfilesTopBar
import com.manarimjesse.githubprofiles.presentation.common.content.PaddingDimens
import com.manarimjesse.githubprofiles.presentation.user_detail.detail_area.UserDetailContainer
import com.manarimjesse.githubprofiles.presentation.user_detail.detail_area.UserDetailState
import com.manarimjesse.githubprofiles.presentation.user_detail.repos_area.UserReposContainer
import com.manarimjesse.githubprofiles.presentation.user_detail.repos_area.UserReposListState
import com.manarimjesse.githubprofiles.ui.theme.Black

@ExperimentalCoilApi
@ExperimentalMaterial3Api
@Composable
fun UserDetailScreen(
    navController: NavHostController,
    detailState: UserDetailState,
    reposState: UserReposListState,
    login: String ,
    onEvent: (UserDetailScreenEvent) -> Unit = { }
){
    LaunchedEffect(Unit){
        onEvent(UserDetailScreenEvent.OnStartLoad(query = login))
        onEvent(UserDetailScreenEvent.OnStartReposLoad(query = login))
    }

    Scaffold(
        topBar = {
            GitHubProfilesTopBar(
                title = stringResource(R.string.github_profiles_title),
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    ){ innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Black)
        ) {
            UserDetailGeneralContainer(
                detailState = detailState,
                reposState = reposState,
                onEvent = onEvent
            )
        }
    }
}

@ExperimentalCoilApi
@Composable
fun UserDetailGeneralContainer(
    detailState: UserDetailState,
    reposState: UserReposListState,
    onEvent: (UserDetailScreenEvent) -> Unit
){
    Column(modifier = Modifier.fillMaxSize()) {
        UserDetailContainer(
            modifier = Modifier.weight(1f),
            state = detailState,
            onEvent = onEvent
        )

        Spacer(modifier = Modifier.padding(PaddingDimens.PADDING_MEDIUM))

        UserReposContainer(
            modifier = Modifier.weight(1.5f),
            state = reposState,
            onEvent = onEvent
        )
    }
}
