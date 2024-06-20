package com.example.uniclass.database

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.uniclass.R

@Composable
fun Database(): List<List<Any>> {

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

    return courses
}