package com.arkamo.rickandmorty.designsystem.foundation.typography.tokens

import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

data class FontSizes(
    val size12: TextUnit,
    val size14: TextUnit,
    val size16: TextUnit,
    val size20: TextUnit,
    val size24: TextUnit,
    val size32: TextUnit,
    val size40: TextUnit,
    val size48: TextUnit,
    val size64: TextUnit,
    val size80: TextUnit,
)

val DefaultFontSize = FontSizes(
    size12 = 12.sp,
    size14 = 14.sp,
    size16 = 16.sp,
    size20 = 20.sp,
    size24 = 24.sp,
    size32 = 32.sp,
    size40 = 40.sp,
    size48 = 48.sp,
    size64 = 64.sp,
    size80 = 80.sp,
)