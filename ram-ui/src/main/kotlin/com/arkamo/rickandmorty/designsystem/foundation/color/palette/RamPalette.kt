package com.arkamo.rickandmorty.designsystem.foundation.color.palette

import androidx.compose.ui.graphics.Color
import com.arkamo.rickandmorty.designsystem.foundation.color.ColorPalette
import com.arkamo.rickandmorty.designsystem.foundation.color.token.BrandColors
import com.arkamo.rickandmorty.designsystem.foundation.color.token.ColorScale
import com.arkamo.rickandmorty.designsystem.foundation.color.token.NeutralColors
import com.arkamo.rickandmorty.designsystem.foundation.color.token.SupportColors

val RamPalette = ColorPalette(
    brand = BrandColors(
        primary = ColorScale(
            darkest = Color(0xFF470000),
            dark = Color(0xFFa30000),
            medium = Color(0xFFe62020),
            light = Color(0xFFe96767),
            lightest = Color(0xFFfaefef),
        ),
        highlight = ColorScale(
            darkest = Color(0xFF253500),
            dark = Color(0xFF366600),
            medium = Color(0xFF3b8700),
            light = Color(0xFF91d65c),
            lightest = Color(0xFFf7faef),
        ),
    ),
    neutral = NeutralColors(
        grayscale = ColorScale(
            darkest = Color(0xFF202020),
            dark = Color(0xFF6c6c6c),
            medium = Color(0xFFdedede),
            light = Color(0xFFf7f7f7),
            lightest = Color(0xFFfcfcfc),
        ),
    ),
    support = SupportColors(
        positive = ColorScale(
            darkest = Color(0xFF003600),
            dark = Color(0xFF006b00),
            medium = Color(0xFF008a05),
            light = Color(0xFF79d279),
            lightest = Color(0xFFeffaef),
        ),
        warning = ColorScale(
            darkest = Color(0xFF472700),
            dark = Color(0xFFa34c00),
            medium = Color(0xFFe16c00),
            light = Color(0xFFf7b687),
            lightest = Color(0xFFfaf4ef),
        ),
        negative = ColorScale(
            darkest = Color(0xFF5c001f),
            dark = Color(0xFFad0048),
            medium = Color(0xFFdf1978),
            light = Color(0xFFf787bc),
            lightest = Color(0xFFfaeff3),
        ),
        alternative = ColorScale(
            darkest = Color(0xFF009c56),
            dark = Color(0xFFfde165),
            medium = Color(0xFF66ab85),
            light = Color(0xFF66ab85),
            lightest = Color(0xFF66ab85),
        ),
    ),
)