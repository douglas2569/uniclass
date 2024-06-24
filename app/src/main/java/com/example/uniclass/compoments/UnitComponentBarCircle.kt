package com.example.uniclass.compoments
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.uniclass.viewModels.StatusColorsBottomBarViewModel

@Composable
fun UnitComponentBarCircle(
    text: String,
    onButtonClick: () -> Unit,
    updatedStatusBottomBarColors: (SnapshotStateList<Map<String, List<Color>>>) ->  Unit,
    getStatusBottomBarColors:() -> SnapshotStateList<Map<String, List<Color>>>,
    viewModel: StatusColorsBottomBarViewModel
) {
    CircularButton( text, onButtonClick, 42.dp, updatedStatusBottomBarColors,getStatusBottomBarColors,viewModel)
}
