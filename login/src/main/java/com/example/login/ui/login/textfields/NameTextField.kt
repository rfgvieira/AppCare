package com.example.login.ui.login.textfields

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
fun NameTextField() {
    var nameState by remember {
        mutableStateOf("")
    }

    TextField(
        value = nameState,
        onValueChange = {
            if(it.length <= 100)
                nameState = it
        },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = colorResource(id = R.color.red),
            focusedIndicatorColor = colorResource(id = R.color.red),
            backgroundColor = Color.White,
        ),
        label = {
            Text(
                text = stringResource(id = R.string.name),
                color = colorResource(id = R.color.red)
            )
        },
        shape = RectangleShape
    )
}