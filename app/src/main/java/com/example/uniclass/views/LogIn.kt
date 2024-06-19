package com.example.uniclass.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.uniclass.R
import com.example.uniclass.compoments.TopBar
import com.example.uniclass.compoments.UnitComponentTopBar

@Composable
fun LogIn(modifier: Modifier = Modifier, onLoginInClick:()->Unit, onSignUpClick:()->Unit) {
    var email = remember {
        mutableStateOf("")
    }
    var password = remember {
        mutableStateOf("")
    }

    var passwordVisibility = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier

    ) {
        TopBar("Log in", { UnitComponentTopBar("", {}) }, { UnitComponentTopBar("", {}) })

        TextField(
            value = email.value,
            onValueChange = {email.value = it},
            label = { Text(text="Email") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp)
        )
        TextField(
            value = password.value, 
            onValueChange = { password.value = it },
            label = { Text(text = "Senha") },
            visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            /*
            trailingIcon = {
                val image = if(passwordVisibility.value)
                                Icon(painter = painterResource(id = R.drawable.visible), contentDescription = "Visivel")
                            else
                                Icon(painter = painterResource(id = R.drawable.invisible), contentDescription = "Invisivel")
                                IconButton(onClick = { passwordVisibility.value != passwordVisibility.value }) {}

            },
             */
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp)
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = { onLoginInClick() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
            ) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(16.dp))
        
        TextButton(onClick = { onSignUpClick() }) {
            Text("Cadastra-se")
        }
    }


}