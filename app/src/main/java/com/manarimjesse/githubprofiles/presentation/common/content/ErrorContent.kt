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
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.manarimjesse.githubprofiles.R
import com.manarimjesse.githubprofiles.ui.theme.Black
import com.manarimjesse.githubprofiles.ui.theme.LightGray
import com.manarimjesse.githubprofiles.ui.theme.MediumGray

@Composable
fun ErrorContent(
    contextMessage: String,
    exception: Exception?,
    onRetry: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = Black)
            .padding(
                horizontal = PaddingDimens.PADDING_EXTRA_LARGE,
                vertical = PaddingDimens.PADDING_MEDIUM
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(modifier = Modifier
            .padding(PaddingDimens.PADDING_SMALL)
            .background(Black)
        ){
            Image(
                painter = painterResource(id = R.drawable.error),
                contentDescription = stringResource(id = R.string.avatar_description),
                modifier = Modifier.size(ImageDimens.IMAGE_SIZE_MEDIUM),
                contentScale = ContentScale.Fit,
            )
        }

        Spacer(modifier = Modifier.padding(PaddingDimens.PADDING_EXTRA_SMALL))

        Text(
            text = stringResource(R.string.error_content_title, contextMessage),
            style = TextStyle(
                color = MediumGray,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
        )

        Spacer(modifier = Modifier.padding(PaddingDimens.PADDING_EXTRA_SMALL))

        Text(
            text = exception?.message ?: stringResource(R.string.unknown_error_description),
            style = TextStyle(
                color = LightGray,
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center
            )
        )

        Spacer(modifier = Modifier.padding(PaddingDimens.PADDING_EXTRA_SMALL))

        Button(
            onClick = { onRetry() }
        ) {
            Text(text = stringResource(R.string.retry))
        }
    }
}