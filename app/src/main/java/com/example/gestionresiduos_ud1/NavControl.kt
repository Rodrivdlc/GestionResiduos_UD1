package com.example.gestionresiduos_ud1

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home_screen") {
        composable("home_screen") { HomeScreen(navController) }
        composable("calendar_screen") { /* Pantalla de calendario */ }
        composable("recycling_map_screen") { /* Pantalla de mapa de reciclaje */ }
        composable("statistics_screen") { /* Pantalla de estadísticas personales */ }
    }
}
