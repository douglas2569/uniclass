package com.example.uniclass.compoments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun ClasseCheckbox(
    userNameFk: String, text: String,
    title: String,
    status:Boolean,
    onStatusChangeClassItem: (userNameFk:String, title:String, status:Boolean) -> Unit,
    setButtonVisibles: (status:Boolean) -> Unit,
    getClassesUpdate:() -> List<Map<String, Any>>,
    coursesTitleFk:String
) {
    var isChecked by remember {
        mutableStateOf(status)
    }

    Row(
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),

        ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = {
                isChecked = it
                onStatusChangeClassItem(userNameFk, title, it)

                val classes = getClassesUpdate()

                var countStatusFalse = 0
                for (itemList in classes) {
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

            }
        )

        Text(text = text, fontSize = 14.sp, color = Color.Gray)
    }
}





//


