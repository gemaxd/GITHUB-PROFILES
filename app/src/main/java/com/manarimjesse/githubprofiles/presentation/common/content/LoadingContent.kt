package com.manarimjesse.githubprofiles.presentation.common.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.manarimjesse.githubprofiles.R
import com.manarimjesse.githubprofiles.ui.theme.Black
import com.manarimjesse.githubprofiles.ui.theme.LightGray
import com.manarimjesse.githubprofiles.ui.theme.MediumGray
import com.manarimjesse.githubprofiles.ui.theme.Red

@Composable
fun LoadingContent(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Black)
            .padding(PaddingDimens.PADDING_EXTRA_LARGE),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        CircularProgressIndicator(modifier = Modifier.size(ImageDimens.IMAGE_SIZE_MEDIUM))

        Spacer(modifier = Modifier.padding(PaddingDimens.PADDING_SMALL))

        Text(
            text = stringResource(R.string.loading_content_title),
            style = TextStyle(
                color = MediumGray,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
            )
        )

        Spacer(modifier = Modifier.padding(PaddingDimens.PADDING_SMALL))

        Text(
            text = stringResource(R.string.loading_content_description),
            style = TextStyle(
                color = LightGray,
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center
            ),
        )
    }
}