package com.example.composetoturial.ui.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable

@Composable
fun BottomNavigationBarScreen(
    items: List<Destination>,
    currentRoute: String?,
    onBottomNavigationItemClick: (Destination) -> Unit
) {

    BottomNavigation {
        items.forEach { item ->
            val isSelected = item.route == currentRoute
            BottomNavigationItem(
                selected = isSelected,
                onClick = { },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = "")
                })
        }

    }

}