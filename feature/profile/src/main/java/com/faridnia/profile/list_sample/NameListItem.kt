package com.faridnia.profile.list_sample

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PersonItemView(
    person: Person,
    familyNames: List<Family>,
    onItemClick: ((name: Person, family: Family) -> Unit)? = null
) {

    val context = LocalContext.current

    var backgroundColor by remember {
        mutableStateOf(Color.Green)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
//            .clickable {
//                onItemClick(person)
//            }
    ) {

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            text = person.name,
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic
        )

        LazyRow(modifier = Modifier.height(50.dp)) {
            items(items = familyNames) { familyItem ->
                Row(
                    modifier = Modifier
                        .fillMaxHeight()
                ) {
                    Text(
                        modifier = Modifier
                            .background(backgroundColor)
                            .clickable {
                                backgroundColor =
                                    if (backgroundColor == Color.Yellow) Color.Green else Color.Yellow
                            },
                        text = familyItem.name
                    )

                    Checkbox(
                        checked = familyItem.isFamilySelected,
                        onCheckedChange = {
                            onItemClick?.invoke(person, familyItem)
                        })
                }

            }
        }

        Divider()

        Column(
            modifier = Modifier.fillMaxSize()
                .padding(15.dp)

                .clickable {
                    Toast.makeText(context,"Yellow",Toast.LENGTH_SHORT).show()
                }
                .background(Color.Yellow)
                .padding(15.dp)
                .clickable {
                    Toast.makeText(context,"Magenta",Toast.LENGTH_SHORT).show()
                }
                .background(Color.Magenta)
                .padding(15.dp)
                .background(Color.Green)
                .clickable {
                    Toast.makeText(context,"Green",Toast.LENGTH_SHORT).show()
                }
                .padding(15.dp)
        ) {}
    }

}

@Preview(showBackground = true)
@Composable
private fun NameItemPreview() {
    PersonItemView(
        person = Person("Milad", true),
        familyNames = listOf(Family("Milad", true)),
        onItemClick = null
    )
}