package com.arkamo.rickandmorty.designsystem.foundation.dimension.token

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Stroke(
    val stroke0: Dp,
    val stroke1: Dp,
    val stroke2: Dp,
    val stroke4: Dp,
)

val DefaultStroke = Stroke(
    stroke0 = 0.dp,
    stroke1 = 1.dp,
    stroke2 = 2.dp,
    stroke4 = 4.dp,
)
