package com.example.main.ui.components

import com.example.main.R

sealed class MenuItems(var text : Int, var icon : Int, var backgroundColor: Int) {
    object Location : MenuItems(R.string.location_menu, R.drawable.location, R.color.blue_light )
    object Doctor : MenuItems(R.string.doctor_menu, R.drawable.user_nurse, R.color.blue_medium )
    object Appointment : MenuItems(R.string.appointment_menu, R.drawable.cross, R.color.blue_medium )
    object Schedule : MenuItems(R.string.er_schedule, R.drawable.calendar, R.color.blue_dark )
    object Urgent : MenuItems(R.string.urgente_location, R.drawable.hospital, R.color.red )
}