package com.example.uniclass.compoments

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uniclass.config.Primary
import com.example.uniclass.viewModels.StatusColorsBottomBarViewModel

@Composable
fun CircularButton(
    content: Any,
    onButtonClick: () -> Unit,
    size: Dp = 60.dp,
    updatedStatusBottomBarColors: (SnapshotStateList<Map<String, List<Color>>>) ->  Unit,
    getStatusBottomBarColors:() -> SnapshotStateList<Map<String, List<Color>>>,
    viewModel: StatusColorsBottomBarViewModel,
    textColor: Color = Color.White,
    bgColor: Color = Primary,

) {
   // var colors = remember{
        // getStatusBottomBarColors().find { it.keys.contains(content)}
    //}

   // val viewModel: StatusColorsBottomBarViewModel = StatusColorsBottomBarViewModel()


    if(content is String) {

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .height(size)
                .width(size)
                .clip(CircleShape)
                .background(
                    //statusItemBottom.value[0]
                    //colors?.get(content)!![0]
                    viewModel.colors.value[content]!![0]
                )
                .clickable {
                    viewModel.changeColor(content)

                    onButtonClick()

                }
        ) {

            Text(
                text = content,
                //color = statusItemBottom.value[1],
                //color = colors[content]!![1],
                color = viewModel.colors.value[content]!![1],
                fontSize = 16.sp
            )

        }
    }
}
