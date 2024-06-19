package com.example.uniclass.compoments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BottomBar(
    buttonCourse: @Composable ()->Unit,
    buttonProfile: @Composable ()->Unit,
    buttonSupport: @Composable ()->Unit
    ){

    Row(modifier = Modifier.fillMaxWidth().background(Color.Blue).padding(top = 16.dp, bottom = 24.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        buttonCourse()
        buttonProfile()
        buttonSupport()

    }

}


