package com.example.composetoturial.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composetoturial.ui.main.MainView
import com.faridnia.wellness.WellnessScreen


@Composable
fun AppNavHost(navHostController: NavHostController, modifier: Modifier) {
    NavHost(
        navController = navHostController,
        startDestination = Destination.Dashboard.route,
        modifier = modifier
    ) {

        composable(Destination.Dashboard.route) {
            WellnessScreen()
        }

        composable(Destination.Dashboard.route) {
            MainView()
        }


    }

}