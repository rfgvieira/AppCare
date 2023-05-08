package com.example.login.ui.login.components

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
fun LoginTextField(text : Int, maxChar: Int, modifier: Modifier) {
    var textState by remember {
        mutableStateOf("")
    }
    TextField(
        value = textState,
        label = {
            Text(
                text = stringResource(id = text),
                color = colorResource(id = R.color.red)
            )
        },
        onValueChange = {
            if(it.length <= maxChar)
                textState = it
        },
        modifier = modifier,
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(cursorColor = colorResource(id = R.color.red),
            focusedIndicatorColor = colorResource(id = R.color.red),
            backgroundColor = Color.White
        ),
        shape = RectangleShape
    )
}