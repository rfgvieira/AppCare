package com.example.main.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.main.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardItem(
    text: Int,
    icon: Int,
    onClick: (Boolean) -> Unit,
    clickFunction: (@Composable () -> Unit)? = null) {
    var clicked by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        onClick = {
            onClick(true)
            clicked = true
        },
        backgroundColor = colorResource(id = R.color.blue_dark),
        shape = RoundedCornerShape(16.dp),
        elevation = 0.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Icon(
                painterResource(id = icon),
                contentDescription = stringResource(id = text),
                modifier = Modifier.size(24.dp),
                tint = Color.White
            )
            Text(
                text = stringResource(id = text),
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 24.dp)
            )

        }
    }

    if (clicked){
        if (clickFunction != null) {
            clickFunction()
        }
    }
}