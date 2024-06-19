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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uniclass.compoments.BottomBar
import com.example.uniclass.compoments.TopBar
import com.example.uniclass.compoments.UnitComponentTopBar

@Composable
fun Main(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween) {
        val navController = rememberNavController()
        NavHost(modifier = Modifier.padding(horizontal = 20.dp), navController = navController, startDestination = "course") {

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
        Box(modifier = Modifier.fillMaxWidth()){
            BottomBar(
                { UnitComponentTopBar("Cursos", {}) },
                { UnitComponentTopBar("Perfil", {}) },
                { UnitComponentTopBar("Suporte", {}) }
            )
        }

    }
    



}