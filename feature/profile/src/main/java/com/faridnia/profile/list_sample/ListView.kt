package com.faridnia.profile.list_sample

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.faridnia.designsystem.previews.ThemePreview
import com.faridnia.designsystem.theme.ComposeToturialTheme

data class Person(
    val name: String,
    val isSelected: Boolean
)

data class Family(
    val name: String,
    val isFamilySelected: Boolean
)

@Composable
fun ListView() {
    val context = LocalContext.current

    val personList by rememberSaveable {
        mutableStateOf(
            listOf(
                Person("Milad", true),
                Person("Bardia", true),
                Person("Paria", false),
                Person("The Others", true)
            )
        )
    }

    var horizontalListItems by rememberSaveable {
        mutableStateOf(
            listOf(
                Family("Faridnia", true),
                Family("Fard", false),
                Family("Farid", false),
                Family("The Others Family", true)
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
                person = person,
                familyNames = horizontalListItems
            ) { clickedPerson: Person, clickedFamily: Family ->

                /*personList = personList.map { mappedPerson ->
                    if (clickedPerson.name == mappedPerson.name) {
                        person.copy(isSelected = clickedPerson.isSelected.not())
                    } else {
                        mappedPerson
                    }
                }*/

                horizontalListItems = horizontalListItems.map { mappedFamily ->
                    if (clickedFamily.name == mappedFamily.name) {
                        clickedFamily.copy(
                            isFamilySelected = clickedFamily.isFamilySelected.not()
                        )
                    } else {
                        mappedFamily
                    }
                }

                Toast.makeText(context, person.name, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@ThemePreview
@Composable
fun DefaultPreview() {
    ComposeToturialTheme(darkTheme = true) {
        ListView()
    }
}