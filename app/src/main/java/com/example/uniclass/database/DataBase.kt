package com.example.uniclass.database

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.example.uniclass.R


@Composable
fun dataCourses(): List<Map<String, Any>> {

    return remember {
        mutableStateListOf(
            mapOf(
                "title" to "Java",
                "image" to R.drawable.ic_launcher_background,
                "imageDescription" to "Decrição Imagem 1",
                "description" to "A linguagem é boa, o povo que é mole.",
                "viewingDate" to "5m ago",
                "status" to false
            ),
            mapOf(
                "title" to "Php",
                "image" to R.drawable.ic_launcher_background,
                "imageDescription" to "Decrição Imagem 1",
                "description" to "MELHOR LINGUAGEM DE TODOS OS TEMPO, para web.",
                "viewingDate" to "1m ago",
                "status" to false
            ),
            mapOf(
                "title" to "Javascript",
                "image" to R.drawable.ic_launcher_background,
                "imageDescription" to "Decrição Imagem 1",
                "description" to "Amo, mas é orientada a gambiarra.",
                "viewingDate" to "3m ago",
                "status" to false
            )
        )
    }
}

@Composable
fun dataClasse(): List<Map<String, Any>> {
    return remember {
        mutableStateListOf(
            mapOf(
                "user_name_fk" to "carlos_123",
                "courses_title_fk" to "Java",
                "image" to R.drawable.ic_launcher_background,
                "imageDescription" to "Decrição Imagem 1",
                "title" to "Introdução a Java",
                "description" to "Subtitulo 1",
                "viewingDate" to "8m ago 1",
                "status" to false,
                "course" to "Java",
            ),
            mapOf(
                "user_name_fk" to "carlos_123",
                "courses_title_fk" to "Java",
                "image" to R.drawable.ic_launcher_background,
                "imageDescription" to "Decrição Imagem 1",
                "title" to "Estrutura de Repetição com Java",
                "description" to "Subtitulo 1",
                "viewingDate" to "8m ago 1",
                "status" to false,
                "course" to "Java",
            ),
            mapOf(
                "user_name_fk" to "carlos_123",
                "courses_title_fk" to "Java",
                "image" to R.drawable.ic_launcher_background,
                "imageDescription" to "Decrição Imagem 1",
                "title" to "Estrutura de Dados com Java",
                "description" to "Subtitulo 1",
                "viewingDate" to "8m ago 1",
                "status" to false
            ),
            mapOf(
                "user_name_fk" to "carlos_123",
                "courses_title_fk" to "Php",
                "image" to R.drawable.ic_launcher_background,
                "imageDescription" to "Decrição Imagem 1",
                "title" to "Introdução ao Php",
                "description" to "Subtitulo 1",
                "viewingDate" to "8m ago 1",
                "status" to false
            ),
            mapOf(
                "user_name_fk" to "carlos_123",
                "courses_title_fk" to "Javascript",
                "image" to R.drawable.ic_launcher_background,
                "imageDescription" to "Decrição Imagem 1",
                "title" to "Introdução ao JS",
                "description" to "Subtitulo 1",
                "viewingDate" to "4m ago",
                "status" to false
            )
        )
    }
}
