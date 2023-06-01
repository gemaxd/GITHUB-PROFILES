package com.manarimjesse.githubprofiles.presentation.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.manarimjesse.githubprofiles.R
import com.manarimjesse.githubprofiles.presentation.common.content.ImageDimens
import com.manarimjesse.githubprofiles.presentation.common.content.PaddingDimens

@ExperimentalCoilApi
@Composable
fun ImageAvatar(
    modifier: Modifier = Modifier,
    url: String?,
    isDetailAvatar: Boolean = false
) {
    val imageSize =
        if (isDetailAvatar)
            ImageDimens.IMAGE_SIZE_EXTRA_LARGE
        else
            ImageDimens.IMAGE_SIZE_MEDIUM

    val painter = rememberImagePainter(
        data = url,
        builder = {
            transformations(CircleCropTransformation())
            crossfade(true)
            placeholder(R.drawable.placeholder)
            error(R.drawable.error)
        }
    )

    Box(
        modifier = Modifier
            .padding(PaddingDimens.PADDING_SMALL)
    ) {
        Image(
            painter = painter,
            contentDescription = stringResource(id = R.string.avatar_description),
            modifier = modifier
                .size(imageSize)
                .clip(CircleShape),
            contentScale = ContentScale.Fit
        )
    }
}
