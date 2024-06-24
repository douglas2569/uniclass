package com.example.uniclass.compoments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uniclass.config.Primary

@Composable
fun SimpleTextButton(name:String, onClick: () -> Unit, color: Color= Primary, shape: RoundedCornerShape = RoundedCornerShape(0.dp), modifier: Modifier = Modifier) {
    TextButton(
        onClick = {
            onClick()
                  },
        modifier = modifier,
        shape = shape

    ) {
        Text(
            text = name,
            color = color,
            fontSize = 16.sp
            )
    }
}