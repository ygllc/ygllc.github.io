package com.yg.website

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.carousel.CarouselDefaults
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yg.website.ui.theme.AppTypography

// Define the data model for the Hero Carousel items
data class HeroItem(
    val id: Int,
    val title: String,
    val description: String,
    val color: Color
)

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun App() {
    // Custom Theme Colors based on the YG LLC screenshot
    val brandPurple = MaterialTheme.colorScheme.onPrimaryFixedVariant  // Main card color
    val backgroundDark = MaterialTheme.colorScheme.primaryFixed // App background
    val titleColor = MaterialTheme.colorScheme.primary     // Header text color (lighter purple)
    val onSurfaceColor = Color.White

    val material3Colors = darkColorScheme(
        primary = titleColor,
        surface = brandPurple,
        background = backgroundDark,
        onSurface = onSurfaceColor
    )

    MaterialExpressiveTheme(colorScheme = material3Colors, typography = AppTypography) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(vertical = 24.dp)
        ) {
            // Header: YG LLC
            Text(
                text = "YG LLC",
                fontSize = 48.sp,
                fontWeight = FontWeight.Black,
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .padding(bottom = 32.dp, top = 20.dp)
            )

            // The Hero Carousel
            HeroCarouselSection()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroCarouselSection() {
    val items = remember {
        listOf(
            HeroItem(
                id = 0,
                title = "MyMileage",
                description = "MyMileage is a modern Android app\nthat makes tracking your vehicle’s\nmileage, fuel efficiency, and trip history\nboth simple and accurate.",
                color = Color(0xFF5B4D7E) // The main purple color
            ),
            HeroItem(
                id = 1,
                title = "Project Beta",
                description = "The next generation of tools.\nComing soon to the portfolio.",
                color = Color(0xFF4A3B69)
            ),
            HeroItem(
                id = 2,
                title = "Analytics",
                description = "Deep dive into your data\nwith our new analytics platform.",
                color = Color(0xFF3E3258)
            ),
            HeroItem(
                id = 3,
                title = "Future App",
                description = "Expanding the ecosystem with\nconnected services.",
                color = Color(0xFF5B4D7E)
            )
        )
    }

    // Carousel State
    val state = rememberCarouselState { items.size }

    // Using HorizontalMultiBrowseCarousel to implement the "Hero" layout strategy.
    // Setting a large preferredItemWidth ensures the main item takes focus,
    // while the component handles the "masking" and "peeking" of the next item automatically.
    HorizontalMultiBrowseCarousel(
        state = state,
        preferredItemWidth = 350.dp, // Large width to create the Hero effect
        itemSpacing = 16.dp,
        contentPadding = PaddingValues(horizontal = 32.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(450.dp) // Fixed height for the hero section
    ) { i ->

        val item = items[i]

        Box(
            modifier = Modifier
                .maskClip(MaterialTheme.shapes.extraLarge)
                .fillMaxSize()
                .background(item.color)
        ) {
            Column(
                modifier = Modifier
                    .padding(32.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = item.title,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = item.description,
                    fontSize = 18.sp,
                    lineHeight = 26.sp,
                    color = Color.White.copy(alpha = 0.9f)
                )
            }
        }
    }
}
