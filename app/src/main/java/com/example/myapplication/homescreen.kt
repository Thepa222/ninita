package com.eiro.myapplication

/*
import android.widget.ExpandableListView
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import java.util.*


@Composable
fun MainScreen(navController: NavHostController?, repository: sneakersRepositoryMock) {
    val sneakers by remember {
        mutableStateOf(repository.getAll(),
    }

    Scaffold(
        topBar = {},
        floatingActionButton = {
            FloatingActionButton(onClick = { navController?.navigate("edit/-1") }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "")

            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        LazyColumn {
            items(sneakers) { sneakers ->
                SneakersListItem(
                    sneakers = sneakers,
                    itemClicklistener = { id -> navController?.navigate("edit/$id") },
                    itemDeleteClickListener = {
                        repository.delete(it)
                    }
            }
        }
    }
}


@Composable
fun SneakersListItem(sneakers: Sneakers, itemClicklistener: (Int) -> Unit, itemDeleteClickListener: (Sneakers) -> Unit) {
                Column () {
                    Divider()
                    Row {
                        Modifier
                            .fillMaxWidth()
                            .padding(15.dp)
                            .clickable {
                                itemClicklistener(sneakers.id)
                            },
                        {

                            Text(text = sneakers.Nike)
                            Divider()
                            Text(text = sneakers.Nike)
                            Text(text = sneakers.Black)
                            Text(text = sneakers.Black)
                        }


                Icon(imageVector = Icons.Default.Delete, contentDescription = "")
            }

*/
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.Sneakers
import com.example.myapplication.sneakersRepositoryMock


@Composable
fun MainScreen(navController: NavHostController?, repository: sneakersRepositoryMock) {
    var sneakers by remember {
        mutableStateOf(repository.getAll())
    }
    Scaffold(
        topBar = {
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController?.navigate("edit/-1") }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "")

            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        LazyColumn {
            items(sneakers) { sneakers ->                SneakersListItem(sneakers = sneakers,
                itemClickListener = { id -> navController?.navigate("edit/$id") },
                itemDeleteClickListener = {
                    repository.delete(it)
                }
            )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListItemPreview() {
    SneakersListItem(sneakers = Sneakers(0, "brand", "123456","2812","Black", "Nike"),
        itemClickListener = {},
        itemDeleteClickListener = {})

}

@Composable
fun SneakersListItem(sneakers: Sneakers,
                     itemClickListener: (Int) -> Unit,
                     itemDeleteClickListener: (Sneakers) -> Unit) {

    Column {
        Divider()
        Row(
            Modifier
                .fillMaxWidth()
                .padding(15.dp)
            , horizontalArrangement = Arrangement.SpaceBetween
            , verticalAlignment =  Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .wrapContentWidth()
                    .clickable {
                        itemClickListener(sneakers.id)
                    }
            ) {
                Text(text = sneakers.Nike)
                Text(text = sneakers.Nike)
                Text(text = sneakers.Black)
                Text(text = sneakers.Black)
            }
            Icon(modifier = Modifier.clickable {
                itemDeleteClickListener(sneakers)
            }, imageVector = Icons.Default.Delete, contentDescription = "" )
        }
    }

}
