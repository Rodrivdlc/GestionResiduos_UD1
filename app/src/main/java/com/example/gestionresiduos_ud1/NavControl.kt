package com.example.gestionresiduos_ud1

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "name_input_screen") {
        composable("name_input_screen") { NameInputScreen(navController) }
        composable(
            "menu_screen/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            MenuScreen(navController, name)
        }
        composable("calendar_screen") { /* Pantalla de calendario */ }
        composable("recycling_map_screen") { /* Pantalla de mapa de reciclaje */ }
        composable("statistics_screen") { /* Pantalla de estadísticas personales */ }
    }
}