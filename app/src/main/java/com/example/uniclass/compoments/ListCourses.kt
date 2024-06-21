package com.example.uniclass.compoments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp


@Composable
fun ListCourses(courses:List<List<Any>>, onGoClassClick: (Any?,String) -> Unit, routeBack:String) {
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .verticalScroll(state)
    ) {
        for (course in courses) {
            Surface(onClick = { onGoClassClick(routeBack, course[2] as String) }) {
                ListCourseItem(course[0] as Painter, course[1] as String,  course[2] as String,  course[3] as String,course[4] as String)
            }

            Spacer(modifier = Modifier.height( 16.dp))
        }
        //para mostrar o ultmo item
        Spacer(modifier = Modifier.height( 80.dp))
    }


}