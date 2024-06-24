package com.example.uniclass.compoments

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uniclass.config.Primary

@Composable
fun ActionButton(name:String, onClick: () -> Unit){
    Button(
        onClick = { onClick() },
        modifier = Modifier.fillMaxWidth().height(50.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Primary),

    ) {
        Text(
            text = name,
            fontSize = 16.sp)
    }
}