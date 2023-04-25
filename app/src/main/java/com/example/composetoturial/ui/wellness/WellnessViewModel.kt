package com.example.composetoturial.ui.wellness

import androidx.lifecycle.ViewModel
import com.example.composetoturial.ui.wellness.model.WellnessTask

class WellnessViewModel : ViewModel() {

    private val _tasks = getWellnessElements().toMutableList()

    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) = _tasks.remove(item)

    fun onTaskCheckChange(task: WellnessTask) {
        _tasks.first { item -> task.id == item.id }
            .checked = task.checked.not()

    }
}

fun getWellnessElements() = List(50) { i ->
    WellnessTask(i, "Task $i", false)
}