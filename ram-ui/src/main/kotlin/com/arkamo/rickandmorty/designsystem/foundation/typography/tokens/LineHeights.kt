package com.arkamo.rickandmorty.designsystem.foundation.typography.tokens

import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

data class LineHeights(
    val height12: TextUnit,
    val height14: TextUnit,
    val height16: TextUnit,
    val height24: TextUnit,
    val height28: TextUnit,
    val height32: TextUnit,
    val height40: TextUnit,
    val height48: TextUnit,
    val height64: TextUnit,
    val height80: TextUnit,
    val height96: TextUnit,
)

val DefaultLineHeight = LineHeights(
    height12 = 12.sp,
    height14 = 14.sp,
    height16 = 16.sp,
    height24 = 24.sp,
    height28 = 28.sp,
    height32 = 32.sp,
    height40 = 40.sp,
    height48 = 48.sp,
    height64 = 64.sp,
    height80 = 80.sp,
    height96 = 96.sp,
)