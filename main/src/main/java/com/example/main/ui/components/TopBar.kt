package com.example.main.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.main.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TopBar(titleString: String, coroutineScope : CoroutineScope, scaffoldState: ScaffoldState) {
    TopAppBar(
        title = {
            Text(text = titleString)
        },
        navigationIcon = {
            IconButton(onClick = { coroutineScope.launch { scaffoldState.drawerState.open() } }) {
                Icon(
                    painterResource(id = R.drawable.menu),
                    contentDescription = "Menu",
                    modifier = Modifier.size(40.dp)
                )
            }
        },
        backgroundColor = colorResource(id = R.color.blue_dark),
        contentColor = Color.White
    )
}
