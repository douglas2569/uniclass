package com.example.uniclass.compoments

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Search(){
    var searchValue by remember { mutableStateOf("") }

    OutlinedTextField(
        value = searchValue,
        shape = RoundedCornerShape(50.dp),
        modifier = Modifier
            .fillMaxWidth()            ,
        onValueChange = {
            searchValue = it
        },
        placeholder = { Text(text = "Search") },

    )
}