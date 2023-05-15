package com.example.main.ui.components

import com.example.main.R

sealed class NavItens(val title: String, val icon: Int, val route: String) {
    object Home : NavItens("Home", R.drawable.home, "home")
    object Chat : NavItens("Chat", R.drawable.chat, "chat")
    object Prescription : NavItens("Prescription", R.drawable.clipboard, "prescription")
    object Profile : NavItens("Profile", R.drawable.user, "profile")
    object Settings : NavItens("Settings", R.drawable.settings, "settings")
}