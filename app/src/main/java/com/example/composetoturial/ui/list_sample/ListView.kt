package com.example.composetoturial.ui.list_sample

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Person(
    val name: String,
    val isSelected: Boolean
)


val horizontalListItems = listOf("Faridnia", "Fard", "Farid", "The Others")

@Composable
fun ListView() {
    val context = LocalContext.current

    var personList by rememberSaveable {
        mutableStateOf(
            listOf(
                Person("Milad", true),
                Person("Bardia", true),
                Person("Paria", false),
                Person("The Others", true)
            )
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        item {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Welcome to Milad Steak House",
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold
            )

            Divider(modifier = Modifier.padding(top = 10.dp))
        }

        items(items = personList) { person ->
            PersonItemView(
                person = person
            ) { clickedPerson ->

                personList = personList.map { mappedPerson ->
                    if (clickedPerson.name == mappedPerson.name) {
                        person.copy(isSelected = clickedPerson.isSelected.not())
                    } else {
                        person
                    }
                }

                Toast.makeText(context, person.name, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ListView()
}