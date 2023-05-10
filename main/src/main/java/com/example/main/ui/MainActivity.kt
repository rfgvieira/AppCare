package com.example.main.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.commons.StringUtils.Companion.capital
import com.example.main.ui.components.*
import com.example.main.ui.screens.HomeScreen
import com.example.main.ui.screens.ProfileScreen
import com.example.main.ui.screens.SettingsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Main { logoutClick() }
        }

    }

    private fun logoutClick(){

        val intent = Intent(this, Class.forName("com.example.login.ui.login.LoginActivity"))
        startActivity(intent)
    }

}

@Composable
private fun Main(logoutClick: () -> Unit) {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    var topBarTitle by remember { mutableStateOf("Home") }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(titleString = topBarTitle, coroutineScope, scaffoldState) },
        bottomBar = { BottomNavigation(navController = navController) },
        drawerContent = { NavDrawer(coroutineScope, scaffoldState, navController,logoutClick)}
    ) {
        NavigationGraph(navHostController = navController, Modifier.padding(it))
    }

    LaunchedEffect(navController) {
        navController.currentBackStackEntryFlow.collect { backStackEntry ->
            topBarTitle = backStackEntry.destination.route?.capital().toString()
        }
    }
}






@Composable
private fun NavigationGraph(
    navHostController: NavHostController,
    modifier: Modifier,
){
    NavHost(
        navController = navHostController,
        startDestination = NavItens.Home.route,
        modifier = modifier.fillMaxWidth()
    ){
        composable(NavItens.Home.route){
            HomeScreen()
        }
        composable(NavItens.Chat.route){
            ChatScreen()
        }
        composable(NavItens.Status.route){
            StatusScreen()
        }
        composable(NavItens.Prescription.route){
            PrescriptionScreen()
        }
        composable(NavItens.Profile.route){
            ProfileScreen()
        }
        composable(NavItens.Settings.route){
            SettingsScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    Main { }
}