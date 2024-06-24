package com.example.uniclass.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.uniclass.compoments.BottomBar
import com.example.uniclass.compoments.UnitComponentBar
import com.example.uniclass.compoments.UnitComponentBarCircle
import com.example.uniclass.config.Primary
import com.example.uniclass.database.dataClasse

@Composable
fun Main(modifier: Modifier = Modifier, onLogOutClick:()->Unit) {
    var classes: List<Map<String, Any>> = dataClasse()


    val onStatusChangeClassItem = { userNameFk:String, title:String, status:Boolean ->
        classes = classes.map { map ->
            if (map["user_name_fk"] == userNameFk && map["title"] == title) {
                map +  ("status" to status)
            }else {
                map
            }
        }
    }

    val getClassesUpdated = { classes  }

    var statusBottomBarColors = remember {
        mutableStateListOf(
            mapOf("C" to listOf(Primary, Color.White)),
            mapOf("P" to listOf(Color.LightGray, Color.Black)),
            mapOf("S" to listOf(Color.LightGray, Color.Black))
        )
    }

    val getStatusBottomBarColors = { statusBottomBarColors }

    val updatedStatusBottomBarColors = { newsStatusBottomBarColors: SnapshotStateList<Map<String, List<Color>>> ->
        statusBottomBarColors = newsStatusBottomBarColors
    }


    Column() {
        val navController = rememberNavController()

        Scaffold(
            topBar = {},

            modifier = modifier.fillMaxHeight(),
            content = { innerPadding ->

                NavHost(navController = navController, startDestination = "course") {

                    composable("course") {
                        Course(
                            onLogOutClick,
                            onBackClassClick = {
                                navController.navigate("course")
                            },
                            onGoClassClick = {
                                    route, title -> navController.navigate("classe/${title}/${route}")
                            }

                        )
                    }

                    composable("profile") {
                        Profile(
                            onLogOutClick,
                        onGoClassClick = {
                                route, title -> navController.navigate("classe/${title}/${route}")
                        },
                        onBackClick = {
                            navController.navigate("profile")
                        })

                    }

                    composable("support") {
                        Support(onBackClick = {
                            navController.navigate("course")
                        })
                    }

                    composable(
                        "classe/{title}/{route}",
                        arguments = listOf(
                            navArgument("title") { NavType.StringType },
                            navArgument("route") {  NavType.StringType }
                        )
                    ) {backStackEntry ->

                        Classes(
                            //onBackClick = { navController.navigate("course") },
                            onBackClick = { backStackEntry.arguments?.getString("route")
                                ?.let { navController.navigate(it) } },
                            title = backStackEntry.arguments?.getString("title"),
                            {
                                BottomBar(
                                    { UnitComponentBar("Cursos", { navController.navigate("course") }) },
                                    { UnitComponentBar("Perfil", { navController.navigate("profile") }) },
                                    { UnitComponentBar("Suporte", { navController.navigate("support") }) }
                                )

                            },20.dp
                            ,onStatusChangeClassItem,
                            classes
                            ,
                            {
                                navController.navigate("certificate")
                            },
                            getClassesUpdated
                        )
                    }

                    composable("certificate") {
                        Certificate(

                            onBackClick = {
                                navController.navigate("course")
                            })

                    }

                }


            },
            bottomBar = {
                Box(modifier = Modifier.fillMaxWidth()){

                    BottomBar(
                        {
                            UnitComponentBarCircle("C", {
                                    navController.navigate("course")
                                },
                                updatedStatusBottomBarColors,
                                getStatusBottomBarColors
                            )
                        },

                        {
                            UnitComponentBarCircle("P",
                                {
                                    navController.navigate("profile")
                                },
                                updatedStatusBottomBarColors,
                                getStatusBottomBarColors
                            )
                        },

                        {
                            UnitComponentBarCircle("S",
                                {
                                    navController.navigate("support")
                                },
                                updatedStatusBottomBarColors,
                                getStatusBottomBarColors
                            )
                        }
                    )

                }
            },
        )



    }


}
