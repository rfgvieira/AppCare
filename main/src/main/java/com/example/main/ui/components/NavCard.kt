package com.example.main.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.main.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NavCard (selected : Boolean, coroutineScope : CoroutineScope, scaffoldState : ScaffoldState, navController : NavController, item : NavItens ) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        onClick = {
            coroutineScope.launch {
                scaffoldState.drawerState.close()
                navController.navigate(item.route)
            }
        },
        backgroundColor = if (selected) Color.White else colorResource(id = R.color.blue_dark),
        shape = RoundedCornerShape(16.dp),
        elevation = 0.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Icon(
                painterResource(id = item.icon),
                contentDescription = item.title,
                modifier = Modifier.size(24.dp),
                tint = if (selected) Color.Black else Color.White
            )
            Text(
                text = item.title,
                color = if (selected) Color.Black else Color.White,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 24.dp)
            )

        }
    }
}