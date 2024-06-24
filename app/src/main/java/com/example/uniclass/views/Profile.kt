package com.example.uniclass.views

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uniclass.R
import com.example.uniclass.compoments.ActionButton
import com.example.uniclass.compoments.ListCourseItem
import com.example.uniclass.compoments.ListCourses
import com.example.uniclass.compoments.SimpleTextButton
import com.example.uniclass.compoments.TopBar
import com.example.uniclass.compoments.UnitComponentBar
import com.example.uniclass.config.Primary
import com.example.uniclass.database.dataCourses

@Composable
fun Profile(onLogOutClick:()->Unit, onGoClassClick: (Any?, Any?) -> Unit, onBackClick:() -> Unit, paddingHorizontal: Dp = 20.dp) {
    var showSheet by remember { mutableStateOf(false) }
    val courses = dataCourses()

    for (itemList in courses) {
        if (itemList["user_name_fk"] == "carlos_123") {
            ListCourseItem(itemList["image"] as Int, itemList["imageDescription"] as String, itemList["title"] as String, itemList["description"] as String, itemList["viewingDate"] as String)
        }
    }

    if (showSheet) {
        BottomSheet() {
            showSheet = false
        }
    }

    Column() {
            Row(modifier = Modifier
                .background(Primary)
                .height(220.dp)
                .padding(top = 60.dp)
                //.padding(
                   // top = WindowInsets
                       // .statusBars
                       // .asPaddingValues()
                       // .calculateTopPadding()
                //)
            ) {
                TopBar(
                    "Perfil",
                    { UnitComponentBar("Settings", { showSheet = true }, Color.White) },
                    { UnitComponentBar("Logout", onLogOutClick, Color.White) },
                    Color.White
                )
            }

        Column(
            modifier = Modifier.padding(horizontal = paddingHorizontal),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            ProfileImage(R.drawable.ic_launcher_background)
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                Modifier.offset(y = (-100).dp)
                ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Text(
                        text = "Victoria Robertson",
                        modifier = Modifier.paddingFromBaseline(
                            top = 24.dp, bottom = 10.dp
                        ),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 24.sp
                    )

                    Text(
                        text = "A mantra goes here",
                        modifier = Modifier.paddingFromBaseline(
                            top = 24.dp, bottom = 10.dp
                        ),
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    DoubleSwitch()

                    Spacer(modifier = Modifier.height(20.dp))

                    Row {
                        ListCourses(courses, onGoClassClick,"profile")
                    }

                }
            }


        }




    }



}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(onDismiss: () -> Unit) {
    val modalBottomSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        Settings()
    }
}

//Bottom Drawer
@Composable
fun Settings() {

    Column(modifier =
    Modifier
        .padding(horizontal = 30.dp)
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Drawer Header",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Consequat velit qui adipisicing sunt do reprehenderit ad laborum tempor ullamco exercitation.",
            fontSize = 16.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(20.dp))
        ActionButton("Click Me", { /*TODO*/ })

        SimpleTextButton("Secondary Action", { /*TODO*/ })

    }
}
@Composable
fun ProfileImage(
    @DrawableRes drawable: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(Modifier.offset(y = (-100).dp)){
            Image(painter = painterResource(id = drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(135.dp)
                    .clip(CircleShape)
                    .border(
                        border = BorderStroke(4.dp, Color.White),
                        shape = RoundedCornerShape(50)
                    )
            )
        }


    }

}

@Composable
fun DoubleSwitch(){
    var stateSwitch by remember { mutableStateOf(true) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(CircleShape)
            .background(color = Color.LightGray)
            .height(50.dp)
        ,

        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = { stateSwitch = !stateSwitch },
            colors = ButtonDefaults.buttonColors(
                if (stateSwitch)
                    Color.White
                else
                    Color.LightGray

            ),
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight()
                .clip(RoundedCornerShape(50))
                .border(
                    border = BorderStroke(4.dp, Color.LightGray),
                    shape = RoundedCornerShape(50)
                )
        ) {
            Text(
                text = "Cursos",
                color = if (stateSwitch)
                        Primary
                    else
                        Color.White,
                fontSize = 16.sp
            )
        }

        Button(
            onClick = { stateSwitch = !stateSwitch },
            colors = ButtonDefaults.buttonColors(
                if (!stateSwitch)
                    Color.White
                else
                    Color.LightGray

            ),
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight()
                .clip(RoundedCornerShape(50))
                .border(
                    border = BorderStroke(4.dp, Color.LightGray),
                    shape = RoundedCornerShape(50)
                ),

        ) {
            Text(
                text = "Photos",
                color = if (!stateSwitch)
                    Primary
                else
                    Color.White,
                fontSize = 16.sp
            )
        }
    }
}
