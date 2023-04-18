package com.example.composetoturial.ui.wellness


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetoturial.ui.wellness.model.WellnessTask


@Composable
fun WellnessTaskList(
    modifier: Modifier = Modifier,
    listItems: List<WellnessTask> = remember {
        getWellnessElements()
    }
) {

    var checkedState by remember {
        mutableStateOf(false)
    }

    LazyColumn() {
        items(listItems) { item ->
            WellnessTaskItem(
                wellnessTask = item,
                onCloseClick = {},
                onCheckChange = { newValue -> checkedState = newValue },
                checkedState = checkedState,
                modifier = modifier
            )
        }
    }
}

fun getWellnessElements() = List(50) { i -> WellnessTask(i, "Task $i") }


@Preview
@Composable
fun WellnessTaskListPreview() {
    WellnessTaskList()
}