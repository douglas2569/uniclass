package com.example.uniclass.views

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.uniclass.compoments.ListCourses
import com.example.uniclass.compoments.Search
import com.example.uniclass.compoments.TopBar
import com.example.uniclass.compoments.UnitComponentTopBar
import com.example.uniclass.database.Database

@Composable

fun Course(onLogInClick:()->Unit, onBackClassClick:()->Unit, onGoClassClick: (Any?, String) -> Unit) {
    var searchValue by remember { mutableStateOf("") }
    val courses:List<Map<String, Any>> = Database().getCourses()

    Column {
        TopBar("Cursos", { UnitComponentTopBar("", {} ) }, { UnitComponentTopBar("Filter", {}) })
        Search()
        ListCourses(courses, onGoClassClick,"course")
    }


}

