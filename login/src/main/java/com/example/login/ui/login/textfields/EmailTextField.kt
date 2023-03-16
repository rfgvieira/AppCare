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
fun EmailTextField() {
    var emailTextState by remember {
        mutableStateOf("")
    }
    TextField(
        value = emailTextState,
        label = {
            Text(
                text = stringResource(id = R.string.email),
                color = colorResource(id = R.color.red)
            )
        },
        onValueChange = {
            if(it.length <= 64)
                emailTextState = it
        },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(cursorColor = colorResource(id = R.color.red),
            focusedIndicatorColor = colorResource(id = R.color.red),
            backgroundColor = Color.White
        ),
        shape = RectangleShape
    )
}