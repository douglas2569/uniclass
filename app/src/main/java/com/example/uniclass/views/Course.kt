package com.example.uniclass.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.uniclass.compoments.ListCourses
import com.example.uniclass.compoments.Search
import com.example.uniclass.compoments.TopBar
import com.example.uniclass.compoments.UnitComponentBar
import com.example.uniclass.database.dataCourses


@Composable

fun Course(onLogInClick:()->Unit, onBackClassClick:()->Unit, onGoClassClick: (Any?, String) -> Unit,  paddingHorizontal: Dp = 20.dp) {
    var searchValue by remember { mutableStateOf("") }
    val courses:List<Map<String, Any>> = dataCourses()

    Column{
        TopBar("Cursos", { UnitComponentBar("", {} ) }, { UnitComponentBar("Filter", {}) })

        Box(modifier = Modifier
            .padding(horizontal = paddingHorizontal)
        ) {
            Search()
        }

        Spacer(modifier = Modifier.height(20.dp))

        Box(modifier = Modifier.padding(horizontal = paddingHorizontal)){
            Search()
            ListCourses(courses, onGoClassClick,"course")
        }


    }


}

