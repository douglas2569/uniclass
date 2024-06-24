package com.example.uniclass.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.uniclass.compoments.ActionButton
import com.example.uniclass.compoments.Search
import com.example.uniclass.compoments.ClasseCheckbox
import com.example.uniclass.compoments.TopBar
import com.example.uniclass.compoments.UnitComponentBar
import com.example.uniclass.database.dataClasse

@Composable
fun Classes(
        onBackClick:()->Unit,
        title:String?,
        bottomBar: @Composable ()->Unit,
        paddingHorizontal: Dp=20.dp,
        onStatusChangeClassItem: (userNameFk:String, title:String, status:Boolean) -> Unit,
        classes:List<Map<String, Any>>,
        onGoCertificate:()->Unit,
        getClassesUpdated:()->List<Map<String, Any>>

) {

    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(0) }

    var isButtonVisible by remember { mutableStateOf(false) }
    val setButtonVisibles = { status:Boolean -> isButtonVisible = status }

    Scaffold(
        topBar = {},

        content = { innerPadding ->
            Column( modifier = Modifier.fillMaxHeight()) {
                TopBar("Aulas", { UnitComponentBar("Back", onBackClick ) }, { UnitComponentBar("Filter", {}) })


                Box(modifier = Modifier
                    .padding(horizontal =  paddingHorizontal)
                ) {
                    Search()
                }

                Spacer(modifier = Modifier.height(20.dp))

                Box(modifier = Modifier
                    .padding(horizontal = paddingHorizontal)
                    .verticalScroll(state)
                ){

                    Column {

                        for (itemList in classes) {
                            if (itemList["user_name_fk"] == "carlos_123" && itemList["courses_title_fk"] == title) {
                                ClasseItem(
                                    itemList["user_name_fk"] as String,
                                    itemList["image"] as Int,
                                    itemList["imageDescription"] as String,
                                    itemList["title"] as String,
                                    itemList["description"] as String,
                                    itemList["viewingDate"] as String,
                                    itemList["status"] as Boolean,
                                    onStatusChangeClassItem,
                                    setButtonVisibles,
                                    getClassesUpdated,
                                    itemList["courses_title_fk"] as String

                                )

                            }
                        }



                        if(isButtonVisible){
                            ActionButton("Certificado", { onGoCertificate() })
                        }

                        Spacer(modifier = Modifier.height( 80.dp))
                    }
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
fun ClasseItem(
    userNameFk:String,
    srcImage: Int,
    imageDescription:String,
    title:String,
    description:String,
    viewingDate:String,
    status:Boolean,
    onStatusChangeClassItem: (userNameFk:String, title:String, status:Boolean) -> Unit,
    setButtonVisibles: (status:Boolean) -> Unit,
    getClassesUpdated:()->List<Map<String, Any>>,
    coursesTitleFk:String
) {

    var countStatusFalse = 0
    for (itemList in getClassesUpdated()) {
        if (
            itemList["user_name_fk"] == "carlos_123" && itemList["courses_title_fk"] == coursesTitleFk && !(itemList["status"] as Boolean)
        ) {
            countStatusFalse += 1

        }
    }

    if (countStatusFalse <= 0)
        setButtonVisibles(true)
    else
        setButtonVisibles(false)

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

        Text(text = title, fontWeight = FontWeight.SemiBold)
        Text(text = description, fontSize = 14.sp)
        Text(text = viewingDate, color = Color.LightGray, fontSize = 14.sp)


        ClasseCheckbox(
            userNameFk,
            "Assistida",
            title,
            status,
            onStatusChangeClassItem,
            setButtonVisibles,
            getClassesUpdated,
            coursesTitleFk
        )


        Spacer(modifier = Modifier.height(16.dp))

    }

}