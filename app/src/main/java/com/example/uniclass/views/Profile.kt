package com.example.uniclass.views

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uniclass.R
import com.example.uniclass.compoments.ListCourses
import com.example.uniclass.compoments.TopBar
import com.example.uniclass.compoments.UnitComponentTopBar
import com.example.uniclass.database.database

@Composable
fun Profile(onLogOutClick:()->Unit, onGoClassClick: (Any?, Any?) -> Unit, onBackClick:() -> Unit) {
    var showSheet by remember { mutableStateOf(false) }
    var courses = database()
    courses = courses.subList(2,5)

    if (showSheet) {
        BottomSheet() {
            showSheet = false
        }
    }

    Column() {
            Spacer(modifier = Modifier.height( 60.dp))
            Row {
                TopBar("Perfil", { UnitComponentTopBar("Settings", { showSheet = true }) }, { UnitComponentTopBar("Logout", onLogOutClick) })
            }

            Row {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    ProfileImage(R.drawable.ic_launcher_background)
                    Text(
                        text = "Victoria Robertson" ,
                        modifier = Modifier.paddingFromBaseline(
                            top = 24.dp, bottom = 8.dp)
                    )

                    Text(
                        text = "A mantra goes here",
                        modifier = Modifier.paddingFromBaseline(
                            top = 24.dp, bottom = 8.dp
                        )
                    )

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
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(Color.LightGray),
                            modifier = Modifier
                                .weight(1F)
                                .fillMaxHeight()
                                .clip(RoundedCornerShape(50))
                                .border(border = BorderStroke(4.dp, Color.LightGray))
                        ) {
                            Text(text = "Posts", color = Color.White)
                        }

                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(Color.White),
                            modifier = Modifier
                                .weight(1F)
                                .fillMaxHeight()
                                .clip(RoundedCornerShape(50))
                                .border(
                                    border = BorderStroke(4.dp, Color.LightGray),
                                    shape = RoundedCornerShape(50)
                                )
                        ) {
                            Text(text = "Photos", color = Color.Green)
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    ListCourses(courses, onGoClassClick,"profile")
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

@Composable
fun Settings() {

    Column(modifier =
        Modifier.padding(horizontal = 20.dp).fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Drawer Header")
        Text(text = "Description")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Click Me")
        }
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Secondary Action")
        }
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
        Image(painter = painterResource(id = drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .border(
                    border = BorderStroke(10.dp, Color.White),
                    shape = RoundedCornerShape(50)
                )
        )

    }

}
