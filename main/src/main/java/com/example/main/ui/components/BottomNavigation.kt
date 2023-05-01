package com.example.main.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.main.R

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        NavItens.Home,
        NavItens.Chat,
        NavItens.Status,
        NavItens.Prescription,
    )

    BottomNavigation(
        backgroundColor = colorResource(id = R.color.blue_dark),
        contentColor = Color.White
    ) {
        val navBackStack by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStack?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                icon = {
                    Icon(
                        painterResource(id = item.icon),
                        contentDescription = stringResource(id = R.string.home),
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = { Text(text = item.title, fontSize = 8.sp) },
                selectedContentColor = colorResource(id = R.color.red),
                unselectedContentColor = Color.White,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )

        }
    }
}

