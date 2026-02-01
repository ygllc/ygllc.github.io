@file:OptIn(ExperimentalTextApi::class)

package com.yg.website.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.ExperimentalTextApi
import org.jetbrains.compose.resources.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation
import companywebsite.composeapp.generated.resources.Res
import companywebsite.composeapp.generated.resources.google_sans_flex_400
import companywebsite.composeapp.generated.resources.google_sans_flex_600
import companywebsite.composeapp.generated.resources.roboto_flex_variable

val baseline = Typography()

val AppTypography
    @Composable get() = Typography().run {
        val bodyFontFamily = FontFamily(Font(Res.font.google_sans_flex_400))
        val displayFontFamily = FontFamily(Font(Res.font.google_sans_flex_600))
        val robotoFlexTopAppBar = FontFamily(
            androidx.compose.ui.text.font.Font(
                R.font.roboto_flex_variable,
                variationSettings = FontVariation.Settings(
                    FontVariation.width(125f),
                    FontVariation.weight(1000),
                    FontVariation.grade(0), // <-- Int, not Float
                    FontVariation.Setting("XOPQ", 96F),
                    FontVariation.Setting("XTRA", 500f),
                    FontVariation.Setting("YOPQ", 79f),
                    FontVariation.Setting("YTAS", 750f),
                    FontVariation.Setting("YTDE", 203f),
                    FontVariation.Setting("YTFI", 738f),
                    FontVariation.Setting("YTLC", 514f),
                    FontVariation.Setting("YTUC", 712f)
                )
            )
        )

        copy(
            displayLarge = baseline.displayLarge.copy(
                fontFamily = displayFontFamily,
                fontFeatureSettings = "ss02, dlig"
            ),
            displayMedium = baseline.displayMedium.copy(
                fontFamily = displayFontFamily,
                fontFeatureSettings = "ss02, dlig"
            ),
            displaySmall = baseline.displaySmall.copy(
                fontFamily = displayFontFamily,
                fontFeatureSettings = "ss02, dlig"
            ),
            headlineLarge = baseline.headlineLarge.copy(
                fontFamily = displayFontFamily,
                fontFeatureSettings = "ss02, dlig"
            ),
            headlineMedium = baseline.headlineMedium.copy(
                fontFamily = displayFontFamily,
                fontFeatureSettings = "ss02, dlig"
            ),
            headlineSmall = baseline.headlineSmall.copy(
                fontFamily = displayFontFamily,
                fontFeatureSettings = "ss02, dlig"
            ),
            titleLarge = baseline.titleLarge.copy(
                fontFamily = displayFontFamily,
                fontFeatureSettings = "ss02, dlig"
            ),
            titleMedium = baseline.titleMedium.copy(
                fontFamily = displayFontFamily,
                fontFeatureSettings = "ss02, dlig"
            ),
            titleSmall = baseline.titleSmall.copy(
                fontFamily = displayFontFamily,
                fontFeatureSettings = "ss02, dlig"
            ),
            bodyLarge = baseline.bodyLarge.copy(
                fontFamily = displayFontFamily,
                fontFeatureSettings = "ss02, dlig"
            ),
            bodyMedium = baseline.bodyMedium.copy(
                fontFamily = bodyFontFamily,
                fontFeatureSettings = "ss02, dlig"
            ),
            bodySmall = baseline.bodySmall.copy(
                fontFamily = bodyFontFamily,
                fontFeatureSettings = "ss02, dlig"
            ),
            labelLarge = baseline.labelLarge.copy(
                fontFamily = displayFontFamily,
                fontFeatureSettings = "ss02, dlig"
            ),
            labelMedium = baseline.labelMedium.copy(
                fontFamily = displayFontFamily,
                fontFeatureSettings = "ss02, dlig"
            ),
            labelSmall = baseline.labelSmall.copy(
                fontFamily = displayFontFamily,
                fontFeatureSettings = "ss02, dlig"
            )
        )
    }



