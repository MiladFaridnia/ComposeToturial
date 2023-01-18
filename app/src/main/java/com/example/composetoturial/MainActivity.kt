package com.example.composetoturial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.composetoturial.ui.MainView
import com.example.composetoturial.ui.theme.ComposeToturialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeToturialTheme {
               MainView()
            }
        }
    }
}

