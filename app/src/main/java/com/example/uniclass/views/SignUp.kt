package com.example.uniclass.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.uniclass.compoments.ActionButton
import com.example.uniclass.compoments.PasswordTextField
import com.example.uniclass.compoments.SimpleCheckbox
import com.example.uniclass.compoments.SimpleTextButton
import com.example.uniclass.compoments.SimpleTextField
import com.example.uniclass.compoments.TopBar
import com.example.uniclass.compoments.UnitComponentBar

@Composable
fun SignUp(modifier: Modifier = Modifier, onCloseClick:()->Unit, onLogInClick:()->Unit, onSignUpClick:()->Unit, paddingHorizontal: Dp = 20.dp) {

  Surface(
    color = Color.White,
    modifier = Modifier
      .fillMaxSize()
      .background(Color.White)

  ) {
    Column(modifier = modifier) {

      TopBar("Sign Up", { UnitComponentBar(Icons.Outlined.Close, onCloseClick) }, { UnitComponentBar("Login", onLogInClick) })

      Spacer(modifier = Modifier.height(24.dp))

      Column {

        SimpleTextField("Nome")

        Spacer(modifier = Modifier.height(20.dp))

        SimpleTextField("Email")

        Spacer(modifier = Modifier.height(20.dp))

        PasswordTextField("Password")

        Spacer(modifier = Modifier.height(20.dp))

        Row(
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically,
          modifier = Modifier.fillMaxWidth(),

        ) {

          SimpleCheckbox("I would like to receive your newsletter and other promotional information.")
        }

        Spacer(modifier = Modifier.weight(1f))


        ActionButton("Sing Up", onSignUpClick )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
          horizontalArrangement = Arrangement.Center,
          modifier = Modifier.fillMaxWidth(),

          ) {

          SimpleTextButton("Forgot your password?",{})
        }

        Spacer(modifier = Modifier.height(20.dp))

      }
    }
  }
}