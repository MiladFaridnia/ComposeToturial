package com.faridnia.wellness


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.faridnia.wellness.model.WellnessTask


@Composable
fun WellnessTaskList(
    modifier: Modifier = Modifier,
    listItems: List<WellnessTask>,
    onTaskCheckChange: (WellnessTask) -> Unit,
    onTaskCloseClick: (WellnessTask) -> Unit
) {

    LazyColumn() {
        items(listItems) { item ->
            WellnessTaskItem(
                wellnessTask = item,
                onCloseClick = onTaskCloseClick,
                onCheckChange = onTaskCheckChange,
                modifier = modifier
            )
        }
    }
}

@Preview
@Composable
private fun WellnessTaskListPreview() {
    WellnessTaskList(
        listItems = remember {
            getWellnessElements()
        },
        onTaskCloseClick = {},
        onTaskCheckChange = {}
    )
}