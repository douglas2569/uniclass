package com.example.uniclass.compoments
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.uniclass.config.Primary

@Composable
fun UnitComponentBar(
    content: Any,
    onButtonClick: () -> Unit,
    textColor: Color = Primary,


) {
    if(content is String)
        Box(Modifier.clickable {

        }) {
            SimpleTextButton(content, onButtonClick, textColor)
        }
    else if(content is ImageVector)
        Box{
            IconButton(onClick = onButtonClick ) {
                //Icon(Icons.Filled.Favorite, contentDescription = "Localized description")
                Icon(
                    content,
                    contentDescription = "Localized description",
                    tint = Color.LightGray
                )

            }
        }

}

