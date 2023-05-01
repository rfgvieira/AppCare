package com.example.main.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.main.R
import kotlinx.coroutines.CoroutineScope

@Composable
fun NavDrawer(
    coroutineScope: CoroutineScope,
    scaffoldState: ScaffoldState,
    navController: NavController
) {
    val navList = listOf(
        NavItens.Profile,
        NavItens.Home,
        NavItens.Chat,
        NavItens.Status,
        NavItens.Prescription,
    )

    val navBackStack by navController.currentBackStackEntryAsState()
    Surface(color = colorResource(id = R.color.blue_dark)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, top = 32.dp, end = 8.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .size(128.dp)
                        .clip(CircleShape)
                        .border(width = 1.dp, color = Color.White, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.menu),
                        contentDescription = "Profile picture",
                        modifier = Modifier.matchParentSize()
                    )
                }

                Spacer(modifier = Modifier.size(16.dp))
                Text(text = "Jorge", color = Color.White, fontSize = 32.sp)
                Spacer(modifier = Modifier.size(8.dp))
                Divider(modifier = Modifier.fillMaxWidth(), color = Color.White)
                Spacer(modifier = Modifier.size(32.dp))

                navList.forEach { item ->
                    val selected = item.route == navBackStack?.destination?.route
                    NavCard(
                        selected = selected,
                        coroutineScope = coroutineScope,
                        scaffoldState = scaffoldState,
                        navController = navController,
                        item = item
                    )

                }

            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                val bottomList = listOf(
                    NavItens.Settings,
                    NavItens.Logout
                )

                Divider(modifier = Modifier.fillMaxWidth(), color = Color.White)
                Spacer(modifier = Modifier.size(16.dp))
                bottomList.forEach { item ->
                    val selected = item.route == navBackStack?.destination?.route
                    NavCard(
                        selected = selected,
                        coroutineScope = coroutineScope,
                        scaffoldState = scaffoldState,
                        navController = navController,
                        item = item
                    )
                }


            }
        }


    }
}


