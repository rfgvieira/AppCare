package com.example.login.ui.login.textfields

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.example.login.R

@Composable
fun PasswordTextField(label : String) {
    var passwordTextState by remember {
        mutableStateOf("")
    }

    TextField(
        value = passwordTextState,
        onValueChange = {
            if(it.length <= 64)
                passwordTextState = it
        },
        singleLine = true,
        label = {
            Text(
                text = label,
                color = colorResource(id = R.color.red)
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = colorResource(id = R.color.red),
            focusedIndicatorColor = colorResource(id = R.color.red),
            backgroundColor = Color.White

        ),
        modifier = Modifier.fillMaxWidth(),
        shape = RectangleShape
    )
}

