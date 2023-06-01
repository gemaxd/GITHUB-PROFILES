package com.manarimjesse.githubprofiles.presentation.user_list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.manarimjesse.githubprofiles.R
import com.manarimjesse.githubprofiles.navigation.Screen
import com.manarimjesse.githubprofiles.presentation.common.components.ImageAvatar
import com.manarimjesse.githubprofiles.presentation.common.components.InputSearch
import com.manarimjesse.githubprofiles.presentation.common.components.SimpleCellDescription
import com.manarimjesse.githubprofiles.presentation.common.content.LoadingContent
import com.manarimjesse.githubprofiles.presentation.common.content.PaddingDimens
import com.manarimjesse.githubprofiles.ui.theme.Black
import com.manarimjesse.githubprofiles.ui.theme.DarkGray

@ExperimentalCoilApi
@ExperimentalMaterial3Api
@Composable
fun UserScreeListContent(
    navController: NavHostController?,
    state: UserListScreenState
){
    val userList by rememberSaveable { mutableStateOf(state.userList) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
    ) {
        LazyColumn(content = {
            items(userList.size) {
                val item = userList[it]

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(PaddingDimens.PADDING_SMALL)
                        .clickable {
                            navController?.navigate(
                                Screen.UserDetailScreen.withArgs(item.login.toString())
                            )
                        },
                    colors = CardDefaults.cardColors(
                        containerColor = DarkGray
                    )
                ) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        ImageAvatar(
                            modifier = Modifier
                                .weight(4f)
                                .background(DarkGray)
                                .padding(horizontal = PaddingDimens.PADDING_SMALL),
                            url = item.avatarUrl
                        )

                        Column(
                            modifier = Modifier
                                .weight(9f)
                                .padding(horizontal = PaddingDimens.PADDING_MEDIUM),
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(modifier = Modifier.fillMaxWidth()) {
                                SimpleCellDescription(
                                    label = stringResource(R.string.user_id),
                                    description = item.id.toString()
                                )

                                SimpleCellDescription(
                                    label = stringResource(R.string.user_login),
                                    description = item.login.toString()
                                )
                            }
                            SimpleCellDescription(
                                label = stringResource(R.string.user_profile),
                                description = item.htmlUrl.toString()
                            )
                        }
                    }
                }
            }
        })
    }
}