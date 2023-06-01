package com.manarimjesse.githubprofiles.presentation.user_detail.repos_area

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.manarimjesse.githubprofiles.R
import com.manarimjesse.githubprofiles.domain.common.model.UserRepo
import com.manarimjesse.githubprofiles.presentation.common.components.SimpleCellDescription
import com.manarimjesse.githubprofiles.presentation.common.components.utils.defaultContentTextStyle
import com.manarimjesse.githubprofiles.presentation.common.components.utils.defaultLabelTextStyle
import com.manarimjesse.githubprofiles.presentation.common.content.PaddingDimens
import com.manarimjesse.githubprofiles.ui.theme.DarkGray

@Composable
fun RepoItemContent(
    repo: UserRepo
){
    Box(
        modifier = Modifier.padding(
            horizontal = PaddingDimens.PADDING_SMALL,
            vertical = PaddingDimens.PADDING_EXTRA_SMALL
        )
    ) {
        Card(
            colors = CardDefaults.cardColors(containerColor = DarkGray),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = PaddingDimens.PADDING_SMALL)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(PaddingDimens.PADDING_SMALL),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    SimpleCellDescription(
                        modifier = Modifier.weight(1f),
                        label = stringResource(R.string.repo_id_label),
                        description = repo.id.toString(),
                        labelTextStyle = defaultLabelTextStyle(textAlign = TextAlign.Center),
                        contentTextStyle = defaultContentTextStyle(textAlign = TextAlign.Center),
                        fillMaxWidth = true
                    )
                    SimpleCellDescription(
                        modifier = Modifier.weight(2f),
                        label = stringResource(R.string.repo_name_label),
                        description = repo.name,
                        fillMaxWidth = true
                    )
                    SimpleCellDescription(
                        modifier = Modifier.weight(3f),
                        label = stringResource(R.string.repo_full_name_label),
                        description = repo.fullName,
                        fillMaxWidth = true
                    )
                    SimpleCellDescription(
                        modifier = Modifier.weight(1f),
                        label = stringResource(R.string.repo_privacity_label),
                        description = repo.private.toString(),
                        labelTextStyle = defaultLabelTextStyle(textAlign = TextAlign.Center),
                        contentTextStyle = defaultContentTextStyle(
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.SemiBold
                        ),
                        fillMaxWidth = true
                    )
                }
            }
        }
    }
}