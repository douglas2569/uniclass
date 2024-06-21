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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.uniclass.R
import com.example.uniclass.compoments.PasswordTextField
import com.example.uniclass.compoments.SimpleTextField
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
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        TopBar("Log in", { UnitComponentTopBar("", {}) }, { UnitComponentTopBar("", {}) })

        SimpleTextField("Email")

        Spacer(modifier = Modifier.height(25.dp))

        PasswordTextField("Password")

        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = { onLoginInClick() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
            ) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(onClick = { onSignUpClick() }) {
            Text("Forgot your password?")
        }

        TextButton(onClick = { onSignUpClick() }) {
            Text("Cadastra-se")
        }
    }


}