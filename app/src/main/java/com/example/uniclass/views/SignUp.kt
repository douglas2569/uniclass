package com.example.uniclass.views

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.uniclass.compoments.TopBar
import com.example.uniclass.compoments.UnitComponentTopBar

@Composable
fun SignUp(modifer: Modifier = Modifier) {
  Column {
    TopBar("Log in", { UnitComponentTopBar("Left", {}) }, { UnitComponentTopBar("Right", {}) })
  }

}