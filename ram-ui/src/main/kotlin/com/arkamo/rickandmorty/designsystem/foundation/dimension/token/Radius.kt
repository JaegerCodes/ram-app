package com.arkamo.rickandmorty.designsystem.foundation.dimension.token

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Radius(
    val radius0: Dp,
    val radius4: Dp,
    val radius8: Dp,
    val radius16: Dp,
    val radius50: Dp,
)

val DefaultRadius = Radius(
    radius0 = 0.dp,
    radius4 = 4.dp,
    radius8 = 8.dp,
    radius16 = 16.dp,
    radius50 = 50.dp
)
