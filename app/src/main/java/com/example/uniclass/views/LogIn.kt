package com.example.uniclass.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uniclass.R
import com.example.uniclass.compoments.ActionButton
import com.example.uniclass.compoments.PasswordTextField
import com.example.uniclass.compoments.SimpleTextButton
import com.example.uniclass.compoments.SimpleTextField
import com.example.uniclass.compoments.TopBar
import com.example.uniclass.compoments.UnitComponentBar
import com.example.uniclass.compoments.UnitComponentBar
import com.example.uniclass.config.Primary

@Composable
fun LogIn(modifier: Modifier = Modifier, onLoginInClick:()->Unit, onSignUpClick:()->Unit, paddingHorizontal: Dp = 20.dp) {
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
        TopBar("Log in", { UnitComponentBar("", {}) }, { UnitComponentBar("", {}) })

        Spacer(modifier = Modifier.height(20.dp))

        SimpleTextField("Email")

        Spacer(modifier = Modifier.height(20.dp))

        PasswordTextField("Password")

        Spacer(modifier = Modifier.weight(1f))

        ActionButton("Login", onLoginInClick )

        SimpleTextButton("Forgot your password?",{})

        SimpleTextButton("Cadastra-se", onSignUpClick)

        Spacer(modifier = Modifier.height(20.dp))
    }
}