package com.manarimjesse.githubprofiles.presentation.user_detail.repos_area

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.manarimjesse.githubprofiles.R
import com.manarimjesse.githubprofiles.presentation.common.content.ErrorContent
import com.manarimjesse.githubprofiles.presentation.common.content.LoadingContent
import com.manarimjesse.githubprofiles.presentation.user_detail.UserDetailScreenEvent

@Composable
fun UserReposContainer(
    modifier: Modifier = Modifier,
    state: UserReposListState,
    onEvent: (UserDetailScreenEvent) -> Unit
){
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(state.isLoading){
            LoadingContent()
        } else if (state.hasError){
            ErrorContent(
                contextMessage = stringResource(R.string.context_user_repos),
                exception = state.exception
            ) {
                onEvent(UserDetailScreenEvent.OnStartReposLoad(state.query))
            }
        } else {
            UserReposContent(state.reposList){
                onEvent(UserDetailScreenEvent.OnStartReposLoad(state.query))
            }
        }
    }
}