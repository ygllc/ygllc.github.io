package com.yg.website

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yg.website.ui.theme.AppTypography

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun App() {
    // Custom Theme Colors based on the YG LLC branding
    val material3Colors = darkColorScheme(
        primary = MaterialTheme.colorScheme.primary,
        surface = MaterialTheme.colorScheme.onPrimaryFixedVariant,
        background = MaterialTheme.colorScheme.primaryFixed,
        onSurface = Color.White
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
                fontFamily = robotoFlexTopAppBar,
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
    data class HeroItem(
        val id: Int,
        val title: String,
        val description: String,
        val color: Color
    )

    val items = remember {
        listOf(
            HeroItem(
                id = 0,
                title = "MyMileage",
                description = "MyMileage is a modern Android app that makes tracking your vehicle’s\nmileage, fuel efficiency, and trip history both simple and accurate.",
                color = Color(0xFF5B4D7E)
            ),
            HeroItem(
                id = 1,
                title = "Fetal Kick",
                description = "Fetal Kick provides expecting parents with a simple, reliable way to\nmonitor their baby’s movements and track trends throughout pregnancy.",
                color = Color(0xFF4A3B69)
            ),
            HeroItem(
                id = 2,
                title = "Analytics",
                description = "Deep dive into your data with our new analytics platform.",
                color = Color(0xFF3E3258)
            ),
            HeroItem(
                id = 3,
                title = "Future App",
                description = "Expanding the ecosystem with connected services.",
                color = Color(0xFF5B4D7E)
            )
        )
    }

    HorizontalMultiBrowseCarousel(
        state = rememberCarouselState { items.count() },
        modifier = Modifier
            .fillMaxWidth()
            .height(450.dp)
            .padding(vertical = 16.dp),
        preferredItemWidth = 350.dp,
        itemSpacing = 16.dp,
        contentPadding = PaddingValues(horizontal = 32.dp)
    ) { i ->
        val item = items[i]
        Box(
            modifier = Modifier
                .fillMaxSize()
                .maskClip(MaterialTheme.shapes.extraLarge)
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
