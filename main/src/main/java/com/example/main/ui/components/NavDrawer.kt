package com.example.main.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.main.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun NavDrawer(
    coroutineScope: CoroutineScope,
    scaffoldState: ScaffoldState,
    navController: NavController,
    logoutClick: () -> Unit
) {
    val navList = listOf(
        NavItens.Home,
        NavItens.Chat,
        NavItens.Prescription,
        NavItens.Profile
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

                Divider(modifier = Modifier.fillMaxWidth(), color = Color.White)
                Spacer(modifier = Modifier.size(16.dp))
                val item = NavItens.Settings
                val selected = item.route == navBackStack?.destination?.route
                NavCard(
                    selected = selected,
                    coroutineScope = coroutineScope,
                    scaffoldState = scaffoldState,
                    navController = navController,
                    item = item
                )

                val showDialog = remember { mutableStateOf(true) }
                CardItem(
                    text = R.string.logoff,
                    icon = R.drawable.logout,
                    clickFunction = {
                        ShowLogoutDialog(logoutClick, showDialog)
                    },
                    onClick = {
                        coroutineScope.launch {
                            scaffoldState.drawerState.close()
                        }
                        showDialog.value = it
                    },
                    backGroundColor = colorResource(id = R.color.blue_dark),
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )


            }
        }


    }

}

@Composable
fun ShowLogoutDialog(logoutClick: () -> Unit, showDialog: MutableState<Boolean>) {

    if (showDialog.value) {
        Dialog(
            modifier = Modifier.fillMaxWidth(),
            confirmPair = Pair(stringResource(id = R.string.sim), logoutClick),
            dismissPair = Pair(stringResource(id = R.string.não), {}),
            showDialog = { showDialog.value = it },
            title = stringResource(id = R.string.logoff),
            textInfo = stringResource(id = R.string.logoff_info)
        )
    }


}


