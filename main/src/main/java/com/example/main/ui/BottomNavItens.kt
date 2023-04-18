package com.example.main.ui

import com.example.main.R

sealed class BottomNavItens(val title : String, val icon : Int, val route : String) {
    object Home : BottomNavItens("Home", R.drawable.home, "home" )
    object Chat : BottomNavItens("Chat", R.drawable.chat, "chat")
    object Status : BottomNavItens("Status", R.drawable.pulse, "status")
    object Prescription  : BottomNavItens("Prescription", R.drawable.clipboard, "prescription")
}