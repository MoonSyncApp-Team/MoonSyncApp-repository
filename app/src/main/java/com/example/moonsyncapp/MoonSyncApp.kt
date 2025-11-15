package com.example.moonsyncapp

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


// Color Palette for MoonSync
object MoonSyncColors {
    val PrimaryPurple = Color(0xFF8B7BA8)
    val LightPurple = Color(0xFFE8DFF5)
    val Pink = Color(0xFFFFB3C1)
    val LightPink = Color(0xFFFDE8EC)
    val DarkText = Color(0xFF2D2D2D)
    val GrayText = Color(0xFF757575)
    val White = Color.White
}

// Navigation Routes
object Routes {
    const val SPLASH = "splash"
    const val WELCOME = "welcome"
    const val LOGIN = "login"
    const val BIRTHDATE = "birthdate"
    const val MEDICATION = "medication"
    const val PILL_SCHEDULE = "pill_schedule"
    const val HOME = "home"
    const val CALENDAR = "calendar"
    const val LOGS = "logs"
    const val NOTIFICATIONS = "notifications"
    const val PROFILE = "profile"
}

@Composable
fun MoonSyncApp() {
    val navController = rememberNavController()
    var selectedTab by remember { mutableStateOf(0) }


    NavHost(
        navController = navController,
        startDestination = Routes.WELCOME
    ) {
        composable(Routes.WELCOME) { WelcomeScreen(navController) }
        composable(Routes.LOGIN) { LoginScreen(navController) }

        // Onboarding flow - each has its own route
        composable(Routes.BIRTHDATE) { BirthdateScreen(navController) }
        composable(Routes.MEDICATION) { MedicationScreen(navController) }
        composable(Routes.PILL_SCHEDULE) { PillScheduleScreen(navController) }

        // Main app screens
        composable(Routes.HOME) { HomeScreen(navController) }
        composable(Routes.CALENDAR) { CalendarScreen(navController) }
        composable(Routes.NOTIFICATIONS) { NotificationsScreen(navController) }
        composable(Routes.PROFILE) { ProfileScreen(navController) }
    }
}