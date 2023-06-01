package com.manarimjesse.githubprofiles.presentation.common.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import com.manarimjesse.githubprofiles.presentation.common.components.utils.defaultContentTextStyle
import com.manarimjesse.githubprofiles.presentation.common.components.utils.defaultLabelTextStyle
import com.manarimjesse.githubprofiles.presentation.common.content.PaddingDimens

@Composable
fun SimpleCellDescription(
    modifier: Modifier = Modifier,
    label: String,
    description: String,
    labelTextStyle: TextStyle = defaultLabelTextStyle(),
    contentTextStyle: TextStyle = defaultContentTextStyle(),
    fillMaxWidth: Boolean = false
){
    val cellModifier = if (fillMaxWidth) Modifier.fillMaxWidth() else Modifier

    Column(
        modifier = modifier.padding(PaddingDimens.PADDING_EXTRA_SMALL),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = cellModifier,
            text = label.uppercase(),
            style = labelTextStyle
        )
        Text(
            modifier = cellModifier,
            text = description,
            style = contentTextStyle
        )
    }
}