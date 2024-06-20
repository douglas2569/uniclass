package com.example.uniclass.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import com.example.uniclass.compoments.Search
import com.example.uniclass.compoments.TopBar
import com.example.uniclass.compoments.UnitComponentTopBar
import com.example.uniclass.database.Database

@Composable

fun Course(onLogInClick:()->Unit, onBackClassClick:()->Unit, onGoClassClick: (Any?) -> Unit) {
    var searchValue by remember { mutableStateOf("") }
    val courses = Database()


    Column() {
        TopBar("Cursos", { UnitComponentTopBar("Logout", onLogInClick ) }, { UnitComponentTopBar("Filter", {}) })
        Search()

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
private fun ScrollContent(courses:List<List<Any>>, onGoClassClick: (Any?) -> Unit) {
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color.LightGray)
            .verticalScroll(state)
    ) {
        for (course in courses) {
            Surface(onClick = { onGoClassClick(course[2] as String) }) {
                ListItem(course[0] as Painter, course[1] as String,  course[2] as String,  course[3] as String)
            }

            Spacer(modifier = Modifier.height( 16.dp))
        }
    }
}