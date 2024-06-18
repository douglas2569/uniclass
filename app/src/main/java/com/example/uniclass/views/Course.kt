package com.example.uniclass.views

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.uniclass.compoments.TopBar
import com.example.uniclass.compoments.UnitComponentTopBar

@Composable
fun Course() {
    Column() {
        TopBar("Cursos", { UnitComponentTopBar("Left", {}) }, { UnitComponentTopBar("Right", {}) })
    }
}