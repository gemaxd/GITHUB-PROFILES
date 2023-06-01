package com.manarimjesse.githubprofiles.presentation.common.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.manarimjesse.githubprofiles.R
import com.manarimjesse.githubprofiles.ui.theme.Black

@Composable
fun EmptyContent(
    onRetry: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = Black)
            .padding(PaddingDimens.PADDING_MEDIUM),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Box(modifier = Modifier.padding(PaddingDimens.PADDING_SMALL)){
            Image(
                painter = painterResource(id = R.drawable.empty),
                contentDescription = stringResource(R.string.avatar_description),
                modifier = Modifier.size(ImageDimens.IMAGE_SIZE_MEDIUM),
                contentScale = ContentScale.Fit
            )
        }

        Spacer(modifier = Modifier.padding(PaddingDimens.PADDING_MEDIUM))

        Text(
            text = stringResource(R.string.empty_content_title),
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
            )
        )

        Spacer(modifier = Modifier.padding(PaddingDimens.PADDING_SMALL))

        Text(
            text = stringResource(R.string.empty_content_description),
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center
            )
        )

        Spacer(modifier = Modifier.padding(PaddingDimens.PADDING_SMALL))

        Button(
            onClick = { onRetry() }
        ) {
            Text(text = stringResource(R.string.reload))
        }
    }
}