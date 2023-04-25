package com.example.composetoturial.ui.wellness

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.composetoturial.ui.previews.ThemePreview

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {

    Column(modifier = modifier) {
        StatefulCounter()
        WellnessTaskList()
    }
}


@ThemePreview
@Composable
private fun WellnessPreview() {
    WellnessScreen()
}
