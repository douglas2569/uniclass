package com.example.uniclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uniclass.ui.theme.UniclassTheme
import com.example.uniclass.views.LogIn
import com.example.uniclass.views.Main
import com.example.uniclass.views.SignUp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UniclassTheme {
                Surface () {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    val modifier:Modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "log in") {

        composable("main") {
            Main(onLogOutClick = {
                navController.navigate("log in")
            })
        }

        composable("log in") {
            LogIn(
                    modifier,
                    onLoginInClick = {
                        navController.navigate("main")
                    },
                    onSignUpClick = {
                        navController.navigate("sign up")
                    },
                )
        }

        composable("sign up") {
            SignUp(
                modifier,
                onCloseClick = {
                    navController.navigate("log in")
                },
                onLogInClick = {
                    navController.navigate("log in")
                },
                onSignUpClick = {
                    navController.navigate("main")
                }
            )
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