package com.arkamo.rickandmorty.designsystem.foundation.color

import com.arkamo.rickandmorty.designsystem.foundation.color.token.BrandColors
import com.arkamo.rickandmorty.designsystem.foundation.color.token.NeutralColors
import com.arkamo.rickandmorty.designsystem.foundation.color.token.SupportColors

/**
 * Contains all color categories for a brand: brand, neutral, and support.
 */
data class ColorPalette(
    val brand: BrandColors,
    val neutral: NeutralColors,
    val support: SupportColors,
)
