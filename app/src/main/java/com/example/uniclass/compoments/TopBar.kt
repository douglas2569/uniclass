package com.example.uniclass.compoments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(title:String, buttonLeft: @Composable ()->Unit, buttonRight: @Composable ()->Unit){
    Spacer(modifier = Modifier.height( 60.dp))

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        buttonLeft()
        Text(text = title)
        buttonRight()

    }

    Spacer(modifier = Modifier.height( 16.dp))
}


