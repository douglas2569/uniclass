package com.example.uniclass.database

import com.example.uniclass.R

class Database{

    private val courses:List<Map<String, Any>> = listOf(
        mapOf(
            "image" to R.drawable.ic_launcher_background,
            "imageDescription" to "Decrição Imagem 1",
            "title" to "Java",
            "description" to "Subtitulo 1",
            "viewingDate" to "8m ago 1",
            "status" to 0
        )
    )

    private val classes:List<Map<String, Any>> = listOf(
        mapOf(
            "id" to "carlos_123",
            "image" to R.drawable.ic_launcher_background,
            "imageDescription" to "Decrição Imagem 1",
            "title" to "Java",
            "description" to "Subtitulo 1",
            "viewingDate" to "8m ago 1",
            "status" to 0,
            "course" to "Java",
        )
    )


    fun getCourses():List<Map<String, Any>>{

        return this.courses
    }

    fun getClasses():List<Map<String, Any>>{

        return this.classes
    }


}
