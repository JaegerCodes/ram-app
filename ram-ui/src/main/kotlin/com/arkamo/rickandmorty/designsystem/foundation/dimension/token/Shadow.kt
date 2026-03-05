package com.arkamo.rickandmorty.designsystem.foundation.dimension.token

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class ShadowLayer(
    val offsetX: Dp,
    val offsetY: Dp,
    val blur: Dp,
    val spread: Dp = 0.dp,
    val color: Color,
    val alpha: Float,
)

data class Shadow(
    val layers: List<ShadowLayer>,
)
