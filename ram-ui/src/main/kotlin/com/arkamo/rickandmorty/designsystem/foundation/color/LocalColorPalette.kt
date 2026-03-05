package com.arkamo.rickandmorty.designsystem.foundation.color

import androidx.compose.runtime.staticCompositionLocalOf
import com.arkamo.rickandmorty.designsystem.foundation.color.palette.RamPalette

/**
 * CompositionLocal to access the current color palette from anywhere in the Compose tree.
 */
val LocalColorPalette = staticCompositionLocalOf<ColorPalette> {
    RamPalette
}
