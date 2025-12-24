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

// Define the data model for the Hero Carousel items
data class HeroItem(
    val title: String,
    val description: String,
    val color: Color
)

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun App() {
    // Custom Theme Colors based on the YG LLC screenshot
    val brandPurple = Color(0xFF5B4D7E)  // Main card color
    val backgroundDark = Color(0xFF1C1B1F) // App background
    val titleColor = Color(0xFFD0BCFF)     // Header text color (lighter purple)
    val onSurfaceColor = Color.White

    val material3Colors = darkColorScheme(
        primary = titleColor,
        surface = brandPurple,
        background = backgroundDark,
        onSurface = onSurfaceColor
    )

    MaterialExpressiveTheme(colorScheme = material3Colors) {
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
                title = "MyMileage",
                description = "MyMileage is a modern Android app\nthat makes tracking your vehicle’s\nmileage, fuel efficiency, and trip history\nboth simple and accurate.",
                color = Color(0xFF5B4D7E) // The main purple color
            ),
            HeroItem(
                title = "Project Beta",
                description = "The next generation of tools.\nComing soon to the portfolio.",
                color = Color(0xFF4A3B69)
            ),
            HeroItem(
                title = "Analytics",
                description = "Deep dive into your data\nwith our new analytics platform.",
                color = Color(0xFF3E3258)
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
        preferredItemWidth = 320.dp, // Large width to create the Hero effect
        itemSpacing = 16.dp,
        contentPadding = PaddingValues(horizontal = 32.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(450.dp) // Fixed height for the hero section
    ) { i ->
        val item = items[i]

        // The carousel item content
        Card(
            colors = CardDefaults.cardColors(containerColor = item.color),
            shape = RoundedCornerShape(28.dp), // M3-style rounded corners
            modifier = Modifier
                .fillMaxSize()
                .maskClip(MaterialTheme.shapes.extraLarge) // Ensures clean clipping during scroll
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
