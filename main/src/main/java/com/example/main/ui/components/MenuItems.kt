package com.example.main.ui.components

import com.example.main.R

sealed class MenuItems(var text : Int, var icon : Int, var backgroundColor: Int, var route : String) {
    object Location : MenuItems(R.string.location_menu, R.drawable.location, R.color.blue_light, "location" )
    object Doctor : MenuItems(R.string.doctor_menu, R.drawable.user_nurse, R.color.blue_medium, "doctor" )
    object Appointment : MenuItems(R.string.appointment_menu, R.drawable.cross, R.color.blue_medium, "appointment" )
    object Schedule : MenuItems(R.string.er_schedule, R.drawable.calendar, R.color.blue_dark, "schedule" )
    object Urgent : MenuItems(R.string.urgente_location, R.drawable.hospital, R.color.red, "urgent" )
}