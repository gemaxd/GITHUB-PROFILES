package com.manarimjesse.githubprofiles.presentation.user_detail.detail_area

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.manarimjesse.githubprofiles.R
import com.manarimjesse.githubprofiles.domain.common.model.GitHubUser
import com.manarimjesse.githubprofiles.presentation.common.components.EmphasisTitle
import com.manarimjesse.githubprofiles.presentation.common.components.ImageAvatar
import com.manarimjesse.githubprofiles.presentation.common.components.SimpleCellDescription
import com.manarimjesse.githubprofiles.presentation.common.components.utils.defaultContentTextStyle
import com.manarimjesse.githubprofiles.presentation.common.components.utils.defaultLabelTextStyle
import com.manarimjesse.githubprofiles.presentation.common.content.ImageDimens
import com.manarimjesse.githubprofiles.presentation.common.content.PaddingDimens

@ExperimentalCoilApi
@Composable
fun UserDetailContent(
    user: GitHubUser
){
    Box(modifier = Modifier.size(ImageDimens.IMAGE_SIZE_LARGE)) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ImageAvatar(
                url = user.avatarUrl ?: "",
                isDetailAvatar = true
            )
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EmphasisTitle(
                modifier = Modifier.fillMaxWidth(),
                title = user.login.toString()
            )
        }
    }

    Spacer(modifier = Modifier.padding(PaddingDimens.PADDING_MEDIUM))

    Row(modifier = Modifier.fillMaxWidth()) {
        SimpleCellDescription(
            modifier = Modifier.weight(1f),
            label = stringResource(R.string.user_id_label),
            description = user.id.toString(),
            labelTextStyle = defaultLabelTextStyle(textAlign = TextAlign.Center),
            contentTextStyle = defaultContentTextStyle(textAlign = TextAlign.Center),
            fillMaxWidth = true
        )

        SimpleCellDescription(
            modifier = Modifier.weight(1f),
            label = stringResource(R.string.github_link_label),
            description = user.htmlUrl.toString(),
            labelTextStyle = defaultLabelTextStyle(textAlign = TextAlign.Center),
            contentTextStyle = defaultContentTextStyle(textAlign = TextAlign.Center),
            fillMaxWidth = true
        )
    }
}