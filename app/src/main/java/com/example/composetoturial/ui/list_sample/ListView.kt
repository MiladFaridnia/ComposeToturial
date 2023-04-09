package com.example.composetoturial.ui.list_sample

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val listItems = listOf("Milad", "Bardia", "Paria", "The Others")
val horizontalListItems = listOf("Faridnia", "Fard", "Farid", "The Others")

@Composable
fun ListView(
    items: List<String> = listItems
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        items(items = listItems) { itemName ->
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = itemName
            )

            LazyRow(modifier = Modifier.height(50.dp)){
                items(items = horizontalListItems) { itemName ->
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = itemName
                    )
                }
            }

        }



    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ListView()
}