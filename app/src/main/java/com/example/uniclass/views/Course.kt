package com.example.uniclass.views

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uniclass.R
import com.example.uniclass.compoments.TopBar
import com.example.uniclass.compoments.UnitComponentTopBar

@Composable

fun Course() {
    var searchValue by remember { mutableStateOf("") }
    val courses:List<Any> = listOf(
        listOf(
            painterResource(R.drawable.ic_launcher_background),
            "Decrição Imagem 1",
            "Titulo1",
            "Subtitulo1"
        ),
        listOf(
            painterResource(R.drawable.ic_launcher_background),
            "Decrição Imagem 2",
            "Titulo2",
            "Subtitulo2"
        )
    )

    Column() {
        TopBar("Cursos", { UnitComponentTopBar("Left", {}) }, { UnitComponentTopBar("Right", {}) })

        OutlinedTextField(
            value = searchValue,
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 20.dp),
            onValueChange = {
                searchValue = it
            },
            placeholder = { Text(text = "Digite sua pesquisa") },
            suffix = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
                }
            },
        )

        Column {
            for (course in courses) {
                listItem(course[0], course[1],  course[2],  course[3])
            }
        }

    }
}

@Composable
fun listItem(srcImage:Painter, imageDescription:String, title:String, subtitle:String){
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.Cyan)
        ) {
            Image(
                painter = srcImage,
                contentDescription = imageDescription
            )
        }

        Column {
            Text(text = title)
            Text(text = subtitle)
        }
    }

}
