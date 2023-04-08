package com.example.composetoturial.ui

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
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
        verticalArrangement = Arrangement.Bottom
    ) {

        var buttonTitle by remember {
            mutableStateOf("Milad Agha Milad")
        }

        var isViewVisible by rememberSaveable {
            mutableStateOf(false)
        }

//        var buttonTitle by rememberSaveable {
//            mutableStateOf("Milad Agha Milad")
//        }

        Spacer(
            modifier = Modifier
                .height(32.dp)
                .padding(16.dp)
        )

        Button(onClick = {

            buttonTitle = if (buttonTitle == "Agha Bardia is the best") {
                "Bardia is the great"
            } else {
                "Agha Bardia is the best"
            }

            isViewVisible = isViewVisible.not()

            Toast.makeText(context, "Button Clicked", Toast.LENGTH_LONG).show()
        })
        {
            if (isViewVisible)
                Text(
                    text = buttonTitle,
                    color = Color.Green
                )
            else
                Text(
                    text = buttonTitle + " Not",
                    color = Color.Yellow
                )

        }

        Spacer(
            modifier = Modifier
                .height(40.dp)
                .padding(16.dp)
        )


        if (isViewVisible) {
            ShowText("Hello Milad Not Visible")

        } else {
            ShowText(buttonTitle)
            ShowText("Hello Milad Visible")
            ShowText("Hi Agha Bardia")
        }


        Spacer(
            modifier = Modifier
                .height(80.dp)
                .padding(16.dp)
        )

    }
}

@Composable
fun ShowText(name: String) {
    Text(text = "$name!")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    MainView()
}