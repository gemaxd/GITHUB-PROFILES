package com.manarimjesse.githubprofiles.presentation.common.components.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.manarimjesse.githubprofiles.ui.theme.LightGray
import com.manarimjesse.githubprofiles.ui.theme.MediumGray

fun defaultContentTextStyle(
    color: Color = LightGray,
    fontWeight: FontWeight = FontWeight.Light,
    fontSize: TextUnit = 12.sp,
    textAlign: TextAlign = TextAlign.Start
) = TextStyle(
    color = color,
    fontWeight = fontWeight,
    fontSize = fontSize,
    textAlign = textAlign
)

fun defaultLabelTextStyle(
    color: Color = MediumGray,
    fontWeight: FontWeight = FontWeight.Medium,
    fontSize: TextUnit = 10.sp,
    textAlign: TextAlign = TextAlign.Start
) = TextStyle(
    color = color,
    fontWeight = fontWeight,
    fontSize = fontSize,
    textAlign = textAlign
)