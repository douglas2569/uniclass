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
fun ListCourses(courses:List<Map<String, Any>>, onGoClassClick: (Any?,String) -> Unit, routeBack:String) {
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(0) }

    Column(
        modifier = Modifier
            .verticalScroll(state)
    ) {

        for (course in courses) {
            Surface(onClick = { onGoClassClick(routeBack, course["title"] as String) }) {
                ListCourseItem(course["image"] as Int, course["imageDescription"] as String, course["title"] as String, course["description"] as String, course["viewingDate"] as String)
            }

        }
        //para mostrar o ultimo item
        //Spacer(modifier = Modifier.height( 80.dp))
    }


}