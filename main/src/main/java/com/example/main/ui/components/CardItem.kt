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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.main.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardItem(
    text: Int,
    icon: Int,
    backGroundColor: Color,
    fontSize: Int = 16,
    isFontBold: Boolean = false,
    iconSize: Int = 24,
    onClick: ((Boolean) -> Unit)? = null,
    clickFunction: (@Composable () -> Unit)? = null,
    modifier: Modifier
) {
    var clicked by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        onClick = {
            if (onClick != null) {
                onClick(true)
            }
            clicked = true
        },
        backgroundColor = backGroundColor,
        shape = RoundedCornerShape(16.dp),
        elevation = 0.dp,

        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = modifier
        ) {
            Icon(
                painterResource(id = icon),
                contentDescription = stringResource(id = text),
                modifier = Modifier.size(iconSize.dp),
                tint = Color.White
            )
            Text(
                text = stringResource(id = text),
                color = Color.White,
                fontSize = fontSize.sp,
                fontWeight = if (isFontBold) FontWeight.Bold else FontWeight.Normal,
                modifier = Modifier.padding(start = 24.dp)
            )

        }
    }

    if (clicked) {
        if (clickFunction != null) {
            clickFunction()
        }
    }
}


@Preview
@Composable
fun CardPreview() {
    CardItem(
        text = R.string.logoff,
        icon = R.drawable.logout,
        backGroundColor = colorResource(id = R.color.red),
        modifier = Modifier
            .padding(vertical = 20.dp, horizontal = 16.dp)
            .fillMaxWidth()
    )
}