package com.agb.github_user_app.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.agb.github_user_app.R

private val gothamFamily = FontFamily(
    Font(R.font.gotham_bold, FontWeight.Bold),
    Font(R.font.gotham_medium, FontWeight.Medium),
    Font(R.font.gotham_thin, FontWeight.Thin)
)

val AppTypography = Typography(
    displayLarge = TextStyle( // large-title
        fontFamily = gothamFamily,
        fontSize = 34.sp,
        lineHeight = 41.sp,
        fontWeight = FontWeight.Normal
    ),
    displayMedium = TextStyle( // title-1
        fontFamily = gothamFamily,

        fontSize = 28.sp,
        lineHeight = 34.sp,
        fontWeight = FontWeight.Normal
    ),
    displaySmall = TextStyle( // title-2
        fontFamily = gothamFamily,

        fontSize = 22.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight.Normal
    ),
    headlineMedium = TextStyle( // title-3
        fontFamily = gothamFamily,

        fontSize = 20.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.Normal
    ),
    headlineSmall = TextStyle( // headline
        fontFamily = gothamFamily,

        fontSize = 17.sp,
        lineHeight = 22.sp,
        fontWeight = FontWeight.Normal
    ),
    bodyLarge = TextStyle( // body
        fontFamily = gothamFamily,

        fontSize = 17.sp,
        lineHeight = 22.sp,
        fontWeight = FontWeight.Normal
    ),
    bodyMedium = TextStyle( // callout
        fontFamily = gothamFamily,

        fontSize = 16.sp,
        lineHeight = 21.sp,
        fontWeight = FontWeight.Normal
    ),
    bodySmall = TextStyle( // sub-headline
        fontFamily = gothamFamily,

        fontSize = 15.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.Normal
    ),
    labelLarge = TextStyle( // footnote
        fontFamily = gothamFamily,

        fontSize = 13.sp,
        lineHeight = 18.sp,
        fontWeight = FontWeight.Normal
    ),
    labelMedium = TextStyle( // caption-1
        fontFamily = gothamFamily,

        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Normal
    ),
    labelSmall = TextStyle( // caption-2
        fontFamily = gothamFamily,
        fontSize = 11.sp,
        lineHeight = 13.sp,
        fontWeight = FontWeight.Normal
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)