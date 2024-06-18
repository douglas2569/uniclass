package com.example.uniclass.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uniclass.compoments.BottomBar
import com.example.uniclass.compoments.TopBar
import com.example.uniclass.compoments.UnitComponentTopBar

@Composable
fun Main(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "course") {

            composable("course") {
                Course()
            }

            composable("classe") {
                Classe()
            }

            composable("profile") {
                Profile()
            }

            composable("support") {
                Support()
            }

        }

        BottomBar(
            { UnitComponentTopBar("Cursos", {}) },
            { UnitComponentTopBar("Perfil", {}) },
            { UnitComponentTopBar("Suporte", {}) }
        )
    }
    



}