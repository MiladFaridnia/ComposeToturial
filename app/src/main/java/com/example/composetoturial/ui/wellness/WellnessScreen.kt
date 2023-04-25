package com.example.composetoturial.ui.wellness

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composetoturial.ui.previews.ThemePreview


@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    viewModel: WellnessViewModel = viewModel()
) {

    Column(modifier = modifier) {
        StatefulCounter()
        WellnessTaskList(
            listItems = viewModel.tasks,
            onTaskCheckChange = { task -> viewModel.onTaskCheckChange(task) },
            onTaskCloseClick = { task -> viewModel.remove(task) }
        )
    }
}


@ThemePreview
@Composable
private fun WellnessPreview() {
    WellnessScreen()
}
