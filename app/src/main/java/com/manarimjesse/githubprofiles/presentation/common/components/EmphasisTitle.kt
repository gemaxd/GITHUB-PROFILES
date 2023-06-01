package com.manarimjesse.githubprofiles.presentation.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.manarimjesse.githubprofiles.presentation.common.content.PaddingDimens.PADDING_MEDIUM
import com.manarimjesse.githubprofiles.presentation.common.content.PaddingDimens.PADDING_SMALL
import com.manarimjesse.githubprofiles.ui.theme.Black

@Composable
fun EmphasisTitle(
    modifier: Modifier = Modifier,
    title: String
){
    BoxWithConstraints {
        Box(modifier = modifier) {
            Column(
                modifier = Modifier
                    .background(color = Black.copy(alpha = 0.5f))
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.padding(
                        vertical = PADDING_SMALL,
                        horizontal = PADDING_MEDIUM
                    ),
                    text = title,
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                )
            }
        }
    }
}