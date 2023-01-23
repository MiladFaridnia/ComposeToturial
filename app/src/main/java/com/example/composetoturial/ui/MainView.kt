package com.example.composetoturial.ui

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun MainView() {

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Spacer(modifier = Modifier
            .height(32.dp)
            .padding(16.dp))
        Button(onClick = {
            Toast.makeText(context , "Button Clicked", Toast.LENGTH_LONG).show()
        }) {
            Text(
                text = "Sample Button",
                color = Color.Green
            )
        }
        ShowText("Milad")
        ShowText("Milad")
        ShowText("Milad")
    }
}

@Composable
fun ShowText(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    MainView()
}