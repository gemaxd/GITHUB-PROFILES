package com.manarimjesse.githubprofiles.presentation.user_detail.repos_area

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.manarimjesse.githubprofiles.R
import com.manarimjesse.githubprofiles.domain.common.model.UserRepo
import com.manarimjesse.githubprofiles.presentation.common.content.EmptyContent
import com.manarimjesse.githubprofiles.presentation.common.content.PaddingDimens
import com.manarimjesse.githubprofiles.ui.theme.MediumGray

@Composable
fun UserReposContent(
    reposList: List<UserRepo>,
    onRetry: () -> Unit
){
    Text(
        modifier = Modifier.fillMaxWidth().padding(PaddingDimens.PADDING_SMALL),
        text = stringResource(R.string.repositories_label),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = MediumGray
        )
    )

    Spacer(modifier = Modifier.padding(PaddingDimens.PADDING_SMALL))

    if(reposList.isEmpty()){
        EmptyContent {
            onRetry()
        }
    } else {
        LazyColumn(
            content = {
                items(reposList.size){ index ->
                    val repo = reposList[index]
                    RepoItemContent(repo)
                }
            }
        )
    }
}