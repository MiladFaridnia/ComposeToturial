package com.example.composetoturial.ui.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

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
                onClick = { onBottomNavigationItemClick(item) },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(imageVector = item.icon, contentDescription = "")
                        AnimatedVisibility(visible = isSelected) {
                            Text(
                                text = item.route,
                                textAlign = TextAlign.Center,
                                fontSize = 9.sp
                            )
                        }
                    }
                })
        }

    }

}