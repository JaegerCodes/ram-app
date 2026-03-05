package com.arkamo.rickandmorty.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.arkamo.rickandmorty.designsystem.foundation.color.ColorPalette
import com.arkamo.rickandmorty.designsystem.foundation.color.LocalColorPalette
import com.arkamo.rickandmorty.designsystem.foundation.color.palette.RamPalette
import com.arkamo.rickandmorty.designsystem.foundation.dimension.DefaultDimensions
import com.arkamo.rickandmorty.designsystem.foundation.dimension.Dimensions
import com.arkamo.rickandmorty.designsystem.foundation.dimension.LocalDimensions
import com.arkamo.rickandmorty.designsystem.foundation.typography.DefaultTypography
import com.arkamo.rickandmorty.designsystem.foundation.typography.LocalTypography
import com.arkamo.rickandmorty.designsystem.foundation.typography.Typography

/**
 * Provides the design system theme configuration to the composition.
 *
 * This composable injects the current color palette, typography, and dimensions
 * via [CompositionLocalProvider], allowing consumers to use [com.arkamo.rickandmorty.designsystem.theme.RickAndMortyAppTheme] to
 * access design tokens consistently.
 *
 * This should be called once at the root of the UI tree (e.g., inside your Activity or NavHost).
 *
 * @param colorPalette the color palette to use (based on selected brand)
 * @param typography the typography tokens to use (shared across brands)
 * @param dimensions the dimension tokens to use (shared across brands)
 * @param content composable content that will inherit the theme
 */
@Composable
fun RickAndMortyAppTheme(
    colorPalette: ColorPalette = RamPalette,
    typography: Typography = DefaultTypography,
    dimensions: Dimensions = DefaultDimensions,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColorPalette provides colorPalette,
        LocalTypography provides typography,
        LocalDimensions provides dimensions,
        content = content
    )
}
