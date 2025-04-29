package com.agb.github_user_app.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

@Composable
fun GithubuserappTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {

    val customColorsPalette = CustomColorsPalette

    CompositionLocalProvider(
        LocalCustomColorsPalette provides customColorsPalette
    ) {
        MaterialTheme(
            colorScheme = LightColorScheme,
            typography = AppTypography,
            content = content
        )
    }
}

// Custom Colors Provider
@Immutable
data class CustomColors(
    val active: Color,
    val error: Color,
    val adminBg: Color,
    val success: Color,
    val bottomNavBarBg: Color,
    val mobileBackground: Brush
)

private val CustomColorsPalette = CustomColors(
    active = ActiveColor,
    error = ErrorColor,
    adminBg = AdminBgColor,
    success = SuccessColor,
    bottomNavBarBg = BottomNavBarBgColor,
    mobileBackground = MobileBackgroundBrush
)

val LocalCustomColorsPalette = staticCompositionLocalOf { CustomColorsPalette }
