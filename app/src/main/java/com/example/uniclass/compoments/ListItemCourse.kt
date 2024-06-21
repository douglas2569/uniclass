package com.example.uniclass.compoments

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun ListCourseItem(srcImage: Int, imageDescription:String, title:String, subtitle:String, viewingDate:String){

    Row(
        Modifier
            .fillMaxWidth()
            .background(Color.White)
    ){

        Box(
            Modifier.height(100.dp)
        ) {
            Image(
                painter = painterResource(srcImage),
                contentDescription = imageDescription
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Box {
            Column {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = title)
                    Text(text = viewingDate)
                }
                Text(text = subtitle)
            }
        }
    }


}