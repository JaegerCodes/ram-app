package com.arkamo.rickandmorty.designsystem.foundation.dimension.token

import com.alicorp.designsystem.foundation.dimension.tokens.DefaultShadowSet
import com.alicorp.designsystem.foundation.dimension.tokens.ShadowSet

data class Effects(
    val opacity: Opacity,
    val shadow: ShadowSet,
)

val DefaultEffects = Effects(
    opacity = DefaultOpacity,
    shadow = DefaultShadowSet,
)
