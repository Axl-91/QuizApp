package com.example.quizapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    data object Home : BottomNavItem("score", Icons.Default.Star, "Score")
    data object Quiz : BottomNavItem("learn", Icons.Default.Home, "Train")
    data object Profile : BottomNavItem("settings", Icons.Default.Settings, "Settings")

    companion object {
        val items = listOf(Home, Quiz, Profile)
    }
}
