package com.arkamo.rickandmorty.designsystem.foundation.dimension

import com.arkamo.rickandmorty.designsystem.foundation.dimension.token.DefaultEffects
import com.arkamo.rickandmorty.designsystem.foundation.dimension.token.DefaultRadius
import com.arkamo.rickandmorty.designsystem.foundation.dimension.token.DefaultSizes
import com.arkamo.rickandmorty.designsystem.foundation.dimension.token.DefaultSpacing
import com.arkamo.rickandmorty.designsystem.foundation.dimension.token.DefaultStroke
import com.arkamo.rickandmorty.designsystem.foundation.dimension.token.Effects
import com.arkamo.rickandmorty.designsystem.foundation.dimension.token.Radius
import com.arkamo.rickandmorty.designsystem.foundation.dimension.token.Sizes
import com.arkamo.rickandmorty.designsystem.foundation.dimension.token.Spacing
import com.arkamo.rickandmorty.designsystem.foundation.dimension.token.Stroke

data class Dimensions(
    val spacing: Spacing,
    val radius: Radius,
    val stroke: Stroke,
    val effects: Effects,
    val sizes: Sizes,
)

val DefaultDimensions = Dimensions(
    spacing = DefaultSpacing,
    radius = DefaultRadius,
    stroke = DefaultStroke,
    effects = DefaultEffects,
    sizes = DefaultSizes,
)
