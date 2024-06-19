package com.example.uniclass.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uniclass.R
import com.example.uniclass.compoments.TopBar
import com.example.uniclass.compoments.UnitComponentTopBar

@Composable

fun Course(onLogInClick:()->Unit, onBackClassClick:()->Unit, onGoClassClick:()->Unit) {
    var searchValue by remember { mutableStateOf("") }
    val courses:List<List<Any>> = listOf(
        listOf(
            painterResource(R.drawable.ic_launcher_background),
            "Decrição Imagem 1",
            "Titulo 1",
            "Subtitulo 1"
        ),
        listOf(
            painterResource(R.drawable.ic_launcher_background),
            "Decrição Imagem 2",
            "Titulo 2",
            "Subtitulo 2"
        ),
        listOf(
            painterResource(R.drawable.ic_launcher_background),
            "Decrição Imagem 3",
            "Titulo 3",
            "Subtitulo 3"
        ),
        listOf(
            painterResource(R.drawable.ic_launcher_background),
            "Decrição Imagem 4",
            "Titulo 4",
            "Subtitulo 4"
        ),
        listOf(
            painterResource(R.drawable.ic_launcher_background),
            "Decrição Imagem 4",
            "Titulo 4",
            "Subtitulo 4"
        ),
        listOf(
            painterResource(R.drawable.ic_launcher_background),
            "Decrição Imagem 5",
            "Titulo 5",
            "Subtitulo 5"
        ),
        listOf(
            painterResource(R.drawable.ic_launcher_background),
            "Decrição Imagem 6",
            "Titulo 6",
            "Subtitulo 6"
        )
    )

    Column() {
        TopBar("Cursos", { UnitComponentTopBar("Logout", onLogInClick ) }, { UnitComponentTopBar("Filter", {}) })

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

        ScrollContent(courses, onGoClassClick)

    }
}

@Composable
private fun ListItem(srcImage:Painter, imageDescription:String, title:String, subtitle:String){


        Row(
            Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
        ){

            Box(
                Modifier.height(100.dp)
            ) {
                Image(
                    painter = srcImage,
                    contentDescription = imageDescription
                )
            }

            Box {
                Column {
                    Text(text = title)
                    Text(text = subtitle)
                }
            }
        }



}

@Composable
private fun ScrollContent(courses:List<List<Any>>, onGoClassClick:()->Unit) {
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }

    Column(
        modifier = Modifier
            .height(500.dp)
            .background(Color.LightGray)
            .verticalScroll(state)
    ) {
        for (course in courses) {
            Surface(onClick = onGoClassClick ) {
                ListItem(course[0] as Painter, course[1] as String,  course[2] as String,  course[3] as String)
            }

            Spacer(modifier = Modifier.height( 16.dp))
        }
    }
}
