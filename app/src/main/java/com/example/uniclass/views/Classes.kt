package com.example.uniclass.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uniclass.compoments.Search
import com.example.uniclass.compoments.SimpleCheckbox
import com.example.uniclass.compoments.TopBar
import com.example.uniclass.compoments.UnitComponentTopBar
import com.example.uniclass.database.Database

@Composable
fun Classes(onBackClick:()->Unit, type:String?, bottomBar: @Composable ()->Unit) {
    val classes:List<Map<String, Any>> = Database().getClasses()
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }

    Scaffold(
        topBar = {},

        content = { innerPadding ->
            Column( modifier = Modifier.fillMaxHeight()) {
                TopBar("Aulas", { UnitComponentTopBar("Back", onBackClick ) }, { UnitComponentTopBar("Filter", {}) })
                Search()

                Column(modifier = Modifier.verticalScroll(state)) {
                    Spacer(modifier = Modifier.height( 35.dp))
                    for (itemList in classes) {
                        if (itemList["id"] == "carlos_123") {
                            ClasseItem(itemList["image"] as Int, itemList["imageDescription"] as String, itemList["title"] as String, itemList["subtitle"] as String, itemList["viewingDate"] as String)
                        }
                    }
                    Spacer(modifier = Modifier.height( 80.dp))
                }
            }

        },
        bottomBar = {
            Box(modifier = Modifier.fillMaxWidth()){
                 bottomBar()
            }
        },

    )


}

@Composable
fun ClasseItem(srcImage: Int, imageDescription:String, title:String, subtitle:String, viewingDate:String) {
    Column(modifier = Modifier
        .fillMaxWidth()
    ) {

        Image(
            painter =  painterResource(srcImage),
            contentDescription = imageDescription,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
            ,

            contentScale = ContentScale.FillWidth

        )
        
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = title)
        Text(text = subtitle)
        Text(text = viewingDate)

    
        SimpleCheckbox("Assistida")

        Spacer(modifier = Modifier.height(16.dp))

    }

}