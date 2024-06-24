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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ListCourseItem(srcImage: Int, imageDescription:String, title:String, description:String, viewingDate:String){

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
                contentDescription = imageDescription,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .width(60.dp)
                    .height(60.dp)
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Box {
            Column {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = title, fontWeight = FontWeight.SemiBold)
                    Text(text = viewingDate, color = Color.LightGray, fontSize = 14.sp)
                }
                Text(text = description, fontSize = 14.sp)
            }
        }
    }


}