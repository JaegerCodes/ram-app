package com.arkamo.rickandmorty.designsystem.foundation.dimension.token

data class Opacity(
    val strong: Float,
    val moderate: Float,
    val light: Float,
    val weak: Float,
)

val DefaultOpacity = Opacity(
    strong = 0.72f,
    moderate = 0.32f,
    light = 0.16f,
    weak = 0.08f,
)
