package com.arkamo.rickandmorty.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.arkamo.rickandmorty.designsystem.foundation.color.ColorPalette
import com.arkamo.rickandmorty.designsystem.foundation.color.LocalColorPalette
import com.arkamo.rickandmorty.designsystem.foundation.dimension.Dimensions
import com.arkamo.rickandmorty.designsystem.foundation.dimension.LocalDimensions
import com.arkamo.rickandmorty.designsystem.foundation.typography.LocalTypography
import com.arkamo.rickandmorty.designsystem.foundation.typography.Typography

/**
 * Static accessor for design system tokens like colors, typography, and dimensions.
 *
 * This object reads from the current [CompositionLocalProvider] provided by [RickAndMortyAppTheme].
 * Use this within composable functions to access the current design tokens.
 *
 * Example:
 * ```
 * Text("Welcome", style = DaliTheme.typography.titleXL)
 * Box(modifier = Modifier.background(DaliTheme.colors.brand.primary.medium))
 * ```
 */
object RamTheme {

    /**
     * Current active color palette injected in the composition.
     */
    val colors: ColorPalette
        @Composable get() = LocalColorPalette.current

    /**
     * Current active typography tokens injected in the composition.
     */
    val typography: Typography
        @Composable get() = LocalTypography.current

    /**
     * Current active dimension tokens injected in the composition.
     */
    val dimensions: Dimensions
        @Composable get() = LocalDimensions.current
}
