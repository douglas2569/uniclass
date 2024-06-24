package com.example.uniclass.viewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.uniclass.config.Primary

class StatusColorsBottomBarViewModel : ViewModel() {

    private val _colors = mutableStateOf(
        mapOf(
            "C" to listOf(Primary, Color.White),
            "P" to listOf(Color.LightGray, Color.Black),
            "S" to listOf(Color.LightGray, Color.Black)
        )
    )

    val colors: MutableState<Map<String, List<Color>>> = _colors

    fun changeColor(name: String) {
        _colors.value = when (name) {
            "C" -> mapOf(
                "C" to listOf(Primary, Color.White),
                "P" to listOf(Color.LightGray, Color.Black),
                "S" to listOf(Color.LightGray, Color.Black)
            )
            "P" -> mapOf(
                "C" to listOf(Color.LightGray, Color.Black),
                "P" to listOf(Primary, Color.White),
                "S" to listOf(Color.LightGray, Color.Black)
            )
            "S" -> mapOf(
                "C" to listOf(Color.LightGray, Color.Black),
                "P" to listOf(Color.LightGray, Color.Black),
                "S" to listOf(Primary, Color.White)
            )
            else -> _colors.value 
        }
    }
}
