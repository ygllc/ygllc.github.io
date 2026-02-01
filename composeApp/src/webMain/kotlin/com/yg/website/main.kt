package com.yg.website

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    // 1. Find the "root" div you created in index.html
    val root = document.getElementById("root") as HTMLElement

    // 2. Pass it to ComposeViewport so the app knows where to draw
    ComposeViewport(root) {
        App()
    }
}