package com.manarimjesse.githubprofiles.presentation.user_detail.detail_area

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import coil.annotation.ExperimentalCoilApi
import com.manarimjesse.githubprofiles.R
import com.manarimjesse.githubprofiles.presentation.common.content.ErrorContent
import com.manarimjesse.githubprofiles.presentation.common.content.LoadingContent
import com.manarimjesse.githubprofiles.presentation.common.content.PaddingDimens
import com.manarimjesse.githubprofiles.presentation.user_detail.UserDetailScreenEvent

@ExperimentalCoilApi
@Composable
fun UserDetailContainer(
    modifier: Modifier = Modifier,
    state: UserDetailState,
    onEvent: (UserDetailScreenEvent) -> Unit
){
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if(state.isLoading){
            LoadingContent()
        } else if(state.hasError){
            ErrorContent(
                contextMessage = stringResource(R.string.context_user_details),
                exception = state.exception
            ){
                onEvent(UserDetailScreenEvent.OnStartLoad(state.query))
            }
        } else {
            UserDetailContent(user = state.user)
        }
    }
}