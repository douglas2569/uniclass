package com.example.uniclass.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.uniclass.compoments.BottomBar
import com.example.uniclass.compoments.TopBar
import com.example.uniclass.compoments.UnitComponentTopBar

@Composable
fun Main(modifier: Modifier = Modifier, onLogOutClick:()->Unit) {
    Column(modifier = modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween) {
        val navController = rememberNavController()
        NavHost(modifier = Modifier.padding(horizontal = 20.dp), navController = navController, startDestination = "course") {

            composable("course") {
                Course(
                    onLogOutClick,
                    onBackClassClick = {
                        navController.navigate("course")
                    },
                    onGoClassClick = {
                        navController.navigate("classe")
                    }

                )
            }

            composable("profile") {
                Profile(onBackClick = {
                    navController.navigate("course")
                })
            }

            composable("support") {
                Support(onBackClick = {
                    navController.navigate("course")
                })
            }

            composable(
                "classe/{type}",
                arguments = listOf(navArgument("type") { type = NavType.StringType })
            ) {backStackEntry ->

                Classe(
                    onBackClick = { navController.navigate("course") },
                    type = backStackEntry.arguments?.getString("type")
                )
            }

        }
        Box(modifier = Modifier.fillMaxWidth()){
            BottomBar(
                { UnitComponentTopBar("Cursos", { navController.navigate("course") }) },
                { UnitComponentTopBar("Perfil", { navController.navigate("profile") }) },
                { UnitComponentTopBar("Suporte", { navController.navigate("support") }) }
            )
        }

    }
    



}