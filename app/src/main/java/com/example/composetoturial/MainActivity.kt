package com.example.composetoturial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composetoturial.ui.navigation.AppNavHost
import com.example.composetoturial.ui.navigation.BottomNavigationBarScreen
import com.example.composetoturial.ui.navigation.bottomNavigationItems
import com.example.composetoturial.ui.theme.ComposeToturialTheme
import com.example.composetoturial.ui.wellness.WellnessScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeToturialTheme {

                val navController = rememberNavController()
                val backStackEntry = navController.currentBackStackEntryAsState()
                val currentScreenRoute = backStackEntry.value?.destination?.route

                Scaffold(
                    bottomBar = {
                        BottomNavigationBarScreen(
                            items = bottomNavigationItems,
                            currentRoute = currentScreenRoute,
                            onBottomNavigationItemClick = {
                                navController.navigate(route = it.route)
                            }
                        )
                    }
                ) { paddingValues ->
                    AppNavHost(
                        navHostController = navController,
                        modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding())
                    )
                }

//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    WellnessScreen()
//                }
            }
        }
    }
}

