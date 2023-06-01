package com.manarimjesse.githubprofiles.presentation.common.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.manarimjesse.githubprofiles.R
import com.manarimjesse.githubprofiles.ui.theme.Blue

@ExperimentalMaterial3Api
@Composable
fun GitHubProfilesTopBar(
    title: String,
    onBack: (() -> Unit)? = null
){
    TopAppBar(
        navigationIcon = {
            onBack?.let {
                IconButton(
                    onClick = { onBack() }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = stringResource(R.string.arrow_back)
                    )
                }
            }
        },
        title = { Text(title) },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Blue,
            titleContentColor = Color.White,
            actionIconContentColor = Color.White,
            navigationIconContentColor = Color.White
        )
    )
}