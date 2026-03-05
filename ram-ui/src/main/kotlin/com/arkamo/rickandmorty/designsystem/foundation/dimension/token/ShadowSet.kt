package com.alicorp.designsystem.foundation.dimension.tokens

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.arkamo.rickandmorty.designsystem.foundation.dimension.token.Shadow
import com.arkamo.rickandmorty.designsystem.foundation.dimension.token.ShadowLayer

data class ShadowSet(
    val up01: Shadow,
    val up02: Shadow,
    val up03: Shadow,
)

val DefaultShadowSet = ShadowSet(
    up01 = Shadow(
        layers = listOf(
            ShadowLayer(0.dp, 0.dp, 4.dp, 0.dp, Color(0xFF202020), 0.32f),
            ShadowLayer(0.dp, (-8).dp, 16.dp, (-4).dp, Color(0xFF202020), 0.16f),
        )
    ),
    up02 = Shadow(
        layers = listOf(
            ShadowLayer(0.dp, 0.dp, 8.dp, 0.dp, Color(0xFF202020), 0.32f),
            ShadowLayer(0.dp, (-16).dp, 32.dp, (-8).dp, Color(0xFF202020), 0.16f),
        )
    ),
    up03 = Shadow(
        layers = listOf(
            ShadowLayer(0.dp, 0.dp, 16.dp, 0.dp, Color(0xFF202020), 0.32f),
            ShadowLayer(0.dp, (-32).dp, 64.dp, (-16).dp, Color(0xFF202020), 0.16f),
        )
    )
)
