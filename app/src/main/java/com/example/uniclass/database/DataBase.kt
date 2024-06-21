package com.example.uniclass.database

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.uniclass.R

@Composable
fun database(): List<List<Any>> {

    val courses:List<List<Any>> = listOf(
        listOf(
            painterResource(R.drawable.ic_launcher_background),
            "Decrição Imagem 1",
            "Titulo 1",
            "Subtitulo 1",
            "8m ago 1",
            0
        ),
        listOf(
            painterResource(R.drawable.ic_launcher_background),
            "Decrição Imagem 2",
            "Titulo 2",
            "Subtitulo 2",
            "8m ago 2",
            0
        ),
        listOf(
            painterResource(R.drawable.ic_launcher_background),
            "Decrição Imagem 3",
            "Titulo 3",
            "Subtitulo 3",
            "8m ago 3",
            0
        ),
        listOf(
            painterResource(R.drawable.ic_launcher_background),
            "Decrição Imagem 4",
            "Titulo 4",
            "Subtitulo 4",
            "8m ago 4",
            0
        ),
        listOf(
            painterResource(R.drawable.ic_launcher_background),
            "Decrição Imagem 5",
            "Titulo 5",
            "Subtitulo 5",
            "8m ago 5",
            0
        ),
        listOf(
            painterResource(R.drawable.ic_launcher_background),
            "Decrição Imagem 6",
            "Titulo 6",
            "Subtitulo 6",
            "8m ago 6",
            0
        ),
        listOf(
            painterResource(R.drawable.ic_launcher_background),
            "Decrição Imagem 7",
            "Titulo 7",
            "Subtitulo 7",
            "8m ago 7",
            0
        ),
        listOf(
            painterResource(R.drawable.ic_launcher_background),
            "Decrição Imagem 8",
            "Titulo 8",
            "Subtitulo 8",
            "8m ago 8",
            0
        )
    )

    return courses
}