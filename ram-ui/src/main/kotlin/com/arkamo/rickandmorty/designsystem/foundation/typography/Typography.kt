package com.arkamo.rickandmorty.designsystem.foundation.typography

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.arkamo.rickandmorty.designsystem.foundation.typography.tokens.DefaultFontFamily
import com.arkamo.rickandmorty.designsystem.foundation.typography.tokens.DefaultFontSize
import com.arkamo.rickandmorty.designsystem.foundation.typography.tokens.DefaultLineHeight
import com.arkamo.rickandmorty.designsystem.foundation.typography.tokens.FontSizes
import com.arkamo.rickandmorty.designsystem.foundation.typography.tokens.LineHeights

data class Typography(
    val titleXXL: TextStyle,
    val titleXL: TextStyle,
    val titleL: TextStyle,
    val titleM: TextStyle,
    val titleS: TextStyle,
    val titleXS: TextStyle,
    val subTitleXS: TextStyle,
    val subTitleXXS: TextStyle,
    val subTitleNano: TextStyle,
    val subTitleQuark: TextStyle,
    val bodyXXS: TextStyle,
    val bodyNano: TextStyle,
    val bodyQuark: TextStyle,
    val linkXXS: TextStyle,
    val linkNano: TextStyle,
    val linkQuark: TextStyle,
    val markXXS: TextStyle,
    val markNano: TextStyle,
    val markQuark: TextStyle,
    val componentS: TextStyle,
    val componentXS: TextStyle,
    val componentXXS: TextStyle,
    val componentNano: TextStyle,
    val componentQuark: TextStyle,
) {
    val bodyXXSBold: TextStyle = bodyXXS.copy(fontWeight = FontWeight.Bold)
    val bodyNanoBold: TextStyle = bodyNano.copy(fontWeight = FontWeight.Bold)
    val bodyQuarkBold: TextStyle = bodyQuark.copy(fontWeight = FontWeight.Bold)

    val componentSSemiBold: TextStyle =
        componentS.copy(fontWeight = FontWeight.SemiBold, lineHeight = DefaultLineHeight.height32)

    val componentXSPlus: TextStyle = componentXS.copy(lineHeight = DefaultLineHeight.height24)
    val componentXSPlusBold: TextStyle = componentXSPlus.copy(fontWeight = FontWeight.Bold)
    val componentXSBold: TextStyle = componentXS.copy(fontWeight = FontWeight.Bold)

    val componentXXSSemiBold: TextStyle = componentXXS.copy(fontWeight = FontWeight.SemiBold)

    val componentXXSBold: TextStyle = componentXXS.copy(fontWeight = FontWeight.Bold)

    val componentNanoPlus: TextStyle = componentNano.copy(lineHeight = DefaultLineHeight.height16)
    val componentNanoPlusSemiBold: TextStyle = componentNanoPlus.copy(fontWeight = FontWeight.SemiBold)
    val componentNanoSemiBold: TextStyle = componentNano.copy(fontWeight = FontWeight.SemiBold)

    val componentQuarkSemiBold: TextStyle = componentQuark.copy(fontWeight = FontWeight.SemiBold)
}

val DefaultTypography = buildTypography(
    font = DefaultFontFamily,
    fontSizes = DefaultFontSize,
    lineHeights = DefaultLineHeight,
)

fun buildTypography(
    font: FontFamily,
    fontSizes: FontSizes,
    lineHeights: LineHeights,
): Typography =
    Typography(
        titleXXL = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Bold,
            fontSize = fontSizes.size80,
            lineHeight = lineHeights.height80,
        ),
        titleXL = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Bold,
            fontSize = fontSizes.size64,
            lineHeight = lineHeights.height80,
        ),
        titleL = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Bold,
            fontSize = fontSizes.size48,
            lineHeight = lineHeights.height64,
        ),
        titleM = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Bold,
            fontSize = fontSizes.size40,
            lineHeight = lineHeights.height48,
        ),
        titleS = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Bold,
            fontSize = fontSizes.size32,
            lineHeight = lineHeights.height40,
        ),
        titleXS = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Bold,
            fontSize = fontSizes.size24,
            lineHeight = lineHeights.height32,
        ),
        subTitleXS = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.SemiBold,
            fontSize = fontSizes.size24,
            lineHeight = lineHeights.height40,
        ),
        subTitleXXS = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.SemiBold,
            fontSize = fontSizes.size16,
            lineHeight = lineHeights.height32,
        ),
        subTitleNano = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.SemiBold,
            fontSize = fontSizes.size14,
            lineHeight = lineHeights.height24,
        ),
        subTitleQuark = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.SemiBold,
            fontSize = fontSizes.size12,
            lineHeight = lineHeights.height16,
        ),
        bodyXXS = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Normal,
            fontSize = fontSizes.size16,
            lineHeight = lineHeights.height32,
        ),
        bodyNano = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Normal,
            fontSize = fontSizes.size14,
            lineHeight = lineHeights.height24,
        ),
        bodyQuark = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Normal,
            fontSize = fontSizes.size12,
            lineHeight = lineHeights.height16,
        ),
        linkXXS = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Normal,
            fontSize = fontSizes.size16,
            lineHeight = lineHeights.height32,
        ),
        linkNano = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Normal,
            fontSize = fontSizes.size14,
            lineHeight = lineHeights.height24,
        ),
        linkQuark = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Normal,
            fontSize = fontSizes.size12,
            lineHeight = lineHeights.height16,
        ),
        markXXS = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Normal,
            fontSize = fontSizes.size16,
            lineHeight = lineHeights.height32,
        ),
        markNano = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Normal,
            fontSize = fontSizes.size14,
            lineHeight = lineHeights.height24,
        ),
        markQuark = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Normal,
            fontSize = fontSizes.size12,
            lineHeight = lineHeights.height16,
        ),
        componentS = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Normal,
            fontSize = fontSizes.size24,
            lineHeight = lineHeights.height28,
        ),
        componentXS = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Normal,
            fontSize = fontSizes.size20,
            lineHeight = lineHeights.height16,
        ),
        componentXXS = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Normal,
            fontSize = fontSizes.size16,
            lineHeight = lineHeights.height24,
        ),
        componentNano = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Normal,
            fontSize = fontSizes.size14,
            lineHeight = lineHeights.height14,
        ),
        componentQuark = TextStyle(
            fontFamily = font,
            fontWeight = FontWeight.Normal,
            fontSize = fontSizes.size12,
            lineHeight = lineHeights.height14,
        ),
    )