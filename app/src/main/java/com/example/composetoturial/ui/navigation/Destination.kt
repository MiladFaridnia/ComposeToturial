package com.example.composetoturial.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destination(val route: String, val icon: ImageVector) {
    object Dashboard : Destination("Dashboard", Icons.Default.Add)
    object List : Destination("List", Icons.Default.Delete)
}

val bottomNavigationItems = listOf(
    Destination.Dashboard,
    Destination.List
)