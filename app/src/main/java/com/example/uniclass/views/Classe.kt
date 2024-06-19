package com.example.uniclass.views

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.uniclass.compoments.TopBar
import com.example.uniclass.compoments.UnitComponentTopBar

@Composable
fun Classe(course:Map<String, Any> = mapOf(), onBackClick:()->Unit) {
    Column() {
        TopBar("Aulas", { UnitComponentTopBar("Back", onBackClick ) }, { UnitComponentTopBar("Right", {}) })
    }
}