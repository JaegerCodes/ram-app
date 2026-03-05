package com.arkamo.rickandmorty.designsystem.foundation.color.token

import androidx.compose.ui.graphics.Color

/**
 * Represents a five-level color scale, from darkest to lightest.
 * Used in branding, support, and neutral palettes.
 */
data class ColorScale(
    val darkest: Color,
    val dark: Color,
    val medium: Color,
    val light: Color,
    val lightest: Color,
)