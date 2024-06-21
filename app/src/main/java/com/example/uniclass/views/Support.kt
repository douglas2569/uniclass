package com.example.uniclass.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.uniclass.compoments.TopBar
import com.example.uniclass.compoments.UnitComponentTopBar

@Composable
fun Support(onBackClick:()->Unit) {
    Column() {
        TopBar("Suporte", { UnitComponentTopBar("Back", onBackClick) }, { UnitComponentTopBar("Filter", {}) })
        Text(text = "Tem mais ta faltando")
    }
}