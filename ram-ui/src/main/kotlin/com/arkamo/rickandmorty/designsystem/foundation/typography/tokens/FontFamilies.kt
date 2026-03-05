package com.arkamo.rickandmorty.designsystem.foundation.typography.tokens

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.arkamo.rickandmorty.designsystem.R

val DefaultFontFamily = FontFamily(
    Font(R.font.poppins_regular, weight = FontWeight.Normal),
    Font(R.font.poppins_medium, weight = FontWeight.SemiBold),
    Font(R.font.poppins_semi_bold, weight = FontWeight.Bold),
)