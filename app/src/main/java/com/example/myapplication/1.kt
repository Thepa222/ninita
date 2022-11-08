package com.example.myapplication
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController


@Composable
fun EditScreen(id: Int?, repository: sneakersRepositoryMock, navController: NavController) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val sneakers = repository.getUserByID(id)
        EditableText(
            label = "Nike",
            value = sneakers.Nike,
            icon = R.drawable.ic_baseline_done_24
        ) {
            sneakers.Nike = it
        }
        EditableText(
            value = sneakers.Black,
            label = "pass",
            icon = R.drawable.ic_baseline_done_24
        ) {
            sneakers.Black = it
        }
        Button(onClick = {
            repository.insert(sneakers)
            navController.navigate("home")
        }) {
            Text(text = "Save")
        }
    }
}



@Composable
fun EditableText(label: String, value: String, icon: Int,listener: (String) -> Unit) {
    var text by remember {
        mutableStateOf(value)
    }
    TextField(
        value = text,
        onValueChange = {
            text = it
            listener(it)
        },
        label = { Text(text = label) },
        leadingIcon = {

            Image(painter = painterResource(id = icon), contentDescription = "")
        })
}
