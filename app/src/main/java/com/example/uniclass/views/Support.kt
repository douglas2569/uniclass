package com.example.uniclass.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.uniclass.compoments.TopBar
import com.example.uniclass.compoments.UnitComponentBar
import com.example.uniclass.config.Primary

@Composable
fun Support(onBackClick: () -> Unit, paddingHorizontal: Dp = 15.dp) {
    var messageText by remember { mutableStateOf("") }
    val messages = remember { mutableStateListOf<Pair<String, Boolean>>() }
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            "Suporte",
            { UnitComponentBar("Back", onBackClick) },
            { UnitComponentBar("Filter", {}) }
        )

        // Coluna com scroll para as mensagens
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(paddingHorizontal)
                .verticalScroll(scrollState)
        ) {
            messages.forEach { (message, isUser) ->
                MessageItem(message, isUser)
            }


        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingHorizontal)
                .padding(bottom = 90.dp),
            verticalAlignment = Alignment.CenterVertically
        ) { // Fecha Row aqui
            OutlinedTextField(
                value = messageText,
                onValueChange = { messageText = it },
                label = { Text("Digite sua mensagem") },
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {
                    if (messageText.isNotBlank()) {
                        messages.add(messageText to true)
                        messageText = ""
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Primary)
            ) {
                Text("Enviar", color = Color.White)
            }
        }
    }
}
@Composable
fun MessageItem(message: String, isUser: Boolean) {
    val messageAlignment = if (isUser) Alignment.End else Alignment.Start
    val messageColor = if (isUser) Color(0xFFE0F7FA) else Color(0xFFEEEEEE)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = messageAlignment
    ) {
        Box(
            modifier = Modifier
                .background(messageColor)
                .padding(10.dp)
        ) {
            Text(
                text = message,
                color = Color.Black
            )
        }
    }
}

    
