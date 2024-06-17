package com.example.uniclass.compoments
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun UnitComponentTopBar(
    content: Any,
    onButtonClick: () -> Unit
) {
    if(content is String)
        Box {
            Button(onClick = onButtonClick) {

                Text(content)
            }
        }
    else if(content is ImageVector)
        Box{
            IconButton(onClick = onButtonClick ) {
                //Icon(Icons.Filled.Favorite, contentDescription = "Localized description")
                Icon(content, contentDescription = "Localized description")
            }
        }

}

