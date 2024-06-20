package com.example.uniclass.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.uniclass.compoments.BottomBar
import com.example.uniclass.compoments.UnitComponentTopBar

@Composable
fun Main(modifier: Modifier = Modifier, onLogOutClick:()->Unit) {
    Column() {
        val navController = rememberNavController()

        Scaffold(
            topBar = {},

            modifier = modifier.fillMaxHeight(),
            content = { innerPadding ->

                NavHost(modifier = Modifier.padding(horizontal = 20.dp), navController = navController, startDestination = "course") {

                    composable("course") {
                        Course(
                            onLogOutClick,
                            onBackClassClick = {
                                navController.navigate("course")
                            },
                            onGoClassClick = {
                                    type -> navController.navigate("classe/${type}")
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


            },
            bottomBar = {
                Box(modifier = Modifier.fillMaxWidth()){
                    BottomBar(
                        { UnitComponentTopBar("Cursos", { navController.navigate("course") }) },
                        { UnitComponentTopBar("Perfil", { navController.navigate("profile") }) },
                        { UnitComponentTopBar("Suporte", { navController.navigate("support") }) }
                    )
                }
            },
        )



    }


}

