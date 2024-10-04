package com.example.gestionresiduos_ud1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gestionresiduos_ud1.Statistics.PersonalWasteStatisticsScreen

class MainComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "name_input_screen") {
                composable("name_input_screen") { NameInputScreen(navController) }
                composable("menu_screen/{name}") { backStackEntry ->
                    val name = backStackEntry.arguments?.getString("name") ?: "Usuario"
                    MenuScreen(navController, name)
                }
                composable("statistics_screen") {
                    PersonalWasteStatisticsScreen()
                }
            }
        }
    }
}