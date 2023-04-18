package com.example.composetoturial.ui.wellness

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.composetoturial.ui.previews.ThemePreview
import com.example.composetoturial.ui.wellness.model.WellnessTask

@Composable
fun WellnessTaskItem(
    wellnessTask: WellnessTask,
    checkedState: Boolean,
    modifier: Modifier,
    onCheckChange: ((Boolean) -> Unit)?,
    onCloseClick: () -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Text(
            text = wellnessTask.label,
            modifier = Modifier
                .weight(1f)
                .padding(8.dp)
        )

        Checkbox(checked = checkedState, onCheckedChange = onCheckChange)

        IconButton(onClick = onCloseClick) {
            Icon(
                Icons.Default.Close,
                contentDescription = "Delete"
            )
        }
    }
}

@ThemePreview
@Composable
private fun DefaultPreview() {
    WellnessTaskItem(
        wellnessTask = WellnessTask(1, "new"),
        checkedState = true,
        modifier = Modifier,
        onCheckChange = {},
        onCloseClick = {})
}