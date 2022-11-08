package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eiro.myapplication.MainScreen
import com.example.myapplication.EditScreen
import com.example.myapplication.sneakersRepositoryMock
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    val repository = sneakersRepositoryMock()
                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") {
                            MainScreen(navController, repository)
                        }
                        composable("edit/{id}") {
                            val value = it.arguments?.getString("id")
                            EditScreen(value?.toInt(), repository, navController)
                        }
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable 
fun  DefaultPrewiew() {
    MyApplicationTheme() {

    }
}