package com.faridnia.wellness

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.faridnia.designsystem.previews.ThemePreview

@ThemePreview
@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var waterCount by rememberSaveable {
        mutableStateOf(0)
    }

    StatelessCounter(modifier = modifier , waterCount) { waterCount++ }

}

@Composable
private fun StatelessCounter(modifier: Modifier, waterCount: Int, increment: () -> Unit) {
    Row(
        modifier = modifier.background(Color.Red).fillMaxWidth()) {

        if (waterCount > 5) {

            Text(
                text = "Glasses of water : $waterCount",
                modifier = Modifier.padding(16.dp)
            )
        }

        Button(
            modifier = Modifier.padding(8.dp),
            enabled = waterCount < 8,
            onClick = increment
        ) {
            Text(text = "Add another Glass")
        }
    }
}