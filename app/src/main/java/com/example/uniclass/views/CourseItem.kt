package com.example.uniclass.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.example.uniclass.compoments.Search
import com.example.uniclass.compoments.SimpleCheckbox
import com.example.uniclass.compoments.TopBar
import com.example.uniclass.compoments.UnitComponentTopBar
import com.example.uniclass.database.database

@Composable
fun CourseItem(onBackClick:()->Unit, type:String?) {
    val courses = database()
    var course:List<Any> = listOf()

    for (itemList in courses) {
        if(itemList[2] == type){
            course = itemList
        }
    }

    Column() {
        TopBar("Aulas", { UnitComponentTopBar("Back", onBackClick ) }, { UnitComponentTopBar("Filter", {}) })
        Search()
        if (type == null) return

        ClasseContent(course[0] as Painter, course[1] as String, course[2] as String, course[3] as String, course[4] as String)
    }
}

@Composable
fun ClasseContent(srcImage: Painter, imageDescription:String, title:String, subtitle:String, viewingDate:String) {
    Column {

        Box(

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
                Text(text = viewingDate)
            }
        }

        SimpleCheckbox("Assistida")

    }

}