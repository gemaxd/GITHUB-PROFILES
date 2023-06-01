package com.manarimjesse.githubprofiles.presentation.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.manarimjesse.githubprofiles.R
import com.manarimjesse.githubprofiles.presentation.common.content.PaddingDimens
import com.manarimjesse.githubprofiles.ui.theme.Black
import com.manarimjesse.githubprofiles.ui.theme.Blue
import com.manarimjesse.githubprofiles.ui.theme.LightBlue
import com.manarimjesse.githubprofiles.ui.theme.LightGray
import com.manarimjesse.githubprofiles.ui.theme.MediumGray

@ExperimentalMaterial3Api
@Composable
fun InputSearch(
    onEvent: ((String) -> Unit)? = null
) {
    var inputText by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Black)
            .padding(PaddingDimens.PADDING_SMALL),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = inputText,
            onValueChange = { inputText = it },
            leadingIcon = {
                Icon(
                    modifier = Modifier.weight(1f),
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = stringResource(R.string.input_search_left_icon_description),
                    tint = Blue
                )
            },
            trailingIcon = {
                IconButton(
                    modifier = Modifier.weight(1f),
                    onClick = {
                        onEvent?.let { it(inputText) }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = stringResource(R.string.input_search_right_icon_description),
                        tint = Blue
                    )
                }
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.user_name_placeholder),
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MediumGray
                    )
                )
            },
            textStyle = TextStyle(
                color = LightGray,
                fontSize = 18.sp
            )
        )
    }
}