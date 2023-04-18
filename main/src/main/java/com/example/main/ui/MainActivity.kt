package com.example.main.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Main()
        }

    }

}

@Composable
private fun Main(){
    val navController = rememberNavController()
    Scaffold(bottomBar = { BottomNavigation(navController = navController)}) {
        NavigationGraph(navHostController = navController, Modifier.padding(it))
    }
}

@Composable
private fun NavigationGraph(navHostController: NavHostController, modifier: Modifier){
    NavHost(
        navController = navHostController,
        startDestination = BottomNavItens.Home.route,
        modifier = modifier.fillMaxWidth()
    ){
        composable(BottomNavItens.Home.route){
            HomeScreen()
        }
        composable(BottomNavItens.Chat.route){
            ChatScreen()
        }
        composable(BottomNavItens.Status.route){
            StatusScreen()
        }
        composable(BottomNavItens.Prescription.route){
            PrescriptionScreen()
        }
    }
}



@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    Main()
}