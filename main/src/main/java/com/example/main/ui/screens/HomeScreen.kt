package com.example.main.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.main.ui.components.CardItem
import com.example.main.ui.components.MenuItems

@Composable
fun HomeScreen(navHostController: NavHostController) {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp, top = 24.dp, bottom = 64.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val menuList = listOf(
            MenuItems.Location,
            MenuItems.Doctor,
            MenuItems.Appointment,
            MenuItems.Schedule,
            MenuItems.Urgent
        )

        menuList.forEach { item ->
            CardItem(
                text = item.text,
                icon = item.icon,
                backGroundColor = colorResource(
                    id = item.backgroundColor
                ),
                fontSize = 24,
                isFontBold = true,
                iconSize = 44,
                modifier = Modifier
                    .padding(vertical = 20.dp, horizontal = 16.dp)
                    .fillMaxWidth(),
                clickFunction = {
                    navHostController.navigate(item.route){
                        navHostController.graph.startDestinationRoute?.let {
                            popUpTo(it) {
                                saveState = true
                            }
                        }
                        restoreState = true
                    }
                }
            )
        }
    }
}

