package com.example.uniclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uniclass.ui.theme.UniclassTheme
import com.example.uniclass.views.LogIn
import com.example.uniclass.views.MainScreen
import com.example.uniclass.views.SignUp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UniclassTheme {
                Scaffold() { innerPadding ->
                    App()
                }
            }
        }
    }
}

@Composable
fun App(modifier:Modifier = Modifier) {
        Surface (
            modifier = modifier.fillMaxSize()
        ){
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "Sign Up") {

                composable("main") {
                    MainScreen()
                }

                composable("Log in") {
                    LogIn()
                }

                composable("Sign Up") {
                    SignUp()
                }

            }

        }

}


@Preview(showBackground = true)
@Composable
fun AppPreview() {
    UniclassTheme {
        App()
    }
}