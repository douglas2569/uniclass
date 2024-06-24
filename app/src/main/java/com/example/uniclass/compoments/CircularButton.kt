package com.example.uniclass.compoments

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uniclass.config.Primary

@Composable
fun CircularButton(
    content: Any,
    onButtonClick: () -> Unit,
    size: Dp = 60.dp,
    updatedStatusBottomBarColors: (SnapshotStateList<Map<String, List<Color>>>) ->  Unit,
    getStatusBottomBarColors:() -> SnapshotStateList<Map<String, List<Color>>>,
    textColor: Color = Color.White,
    bgColor: Color = Primary,
) {
    var colors = remember{
         getStatusBottomBarColors().find { it.keys.contains(content)}
    }

    if(content is String) {

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .height(size)
                .width(size)
                .clip(CircleShape)
                .background(
                    //statusItemBottom.value[0]
                    colors?.get(content)!![0]
                )
                .clickable {
                    when (content) {
                        "C" -> {
                            updatedStatusBottomBarColors(
                                mutableStateListOf(
                                    mapOf("C" to listOf(Primary, Color.White)),
                                    mapOf("P" to listOf(Color.LightGray, Color.Black)),
                                    mapOf("S" to listOf(Color.LightGray, Color.Black)),
                                )
                            )

                        }

                        "P" -> {
                            updatedStatusBottomBarColors(
                                mutableStateListOf(
                                    mapOf("C" to listOf(Color.LightGray, Color.Black)),
                                    mapOf("P" to listOf(Primary, Color.White)),
                                    mapOf("S" to listOf(Color.LightGray, Color.Black))
                                )
                            )
                        }

                        "S" -> {
                            updatedStatusBottomBarColors(
                                mutableStateListOf(
                                    mapOf("C" to listOf(Color.LightGray, Color.Black)),
                                    mapOf("P" to listOf(Color.LightGray, Color.Black)),
                                    mapOf("S" to listOf(Primary, Color.White)),
                                )
                            )
                        }

                    }

                    onButtonClick()

                }
        ) {

            Text(
                text = content,
                //color = statusItemBottom.value[1],
                color = colors[content]!![1],
                fontSize = 16.sp
            )

        }
    }
}
