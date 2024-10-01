package com.example.gestionresiduos_ud1

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import java.util.*

@Composable
fun HomeScreen(navController: NavController) {
    val greeting = getGreetingMessage()

    // Estructura principal de la pantalla de inicio
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Saludo personalizado
        Text(
            text = greeting,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Botón para ir a la sección de calendario
        Button(
            onClick = { navController.navigate("calendar_screen") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text(text = "Ver calendario de recolección")
        }

        // Botón para ir a la sección de mapa
        Button(
            onClick = { navController.navigate("recycling_map_screen") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text(text = "Ver puntos de reciclaje")
        }

        // Botón para ir a la sección de estadísticas personales
        Button(
            onClick = { navController.navigate("statistics_screen") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Ver estadísticas personales")
        }
    }
}

@Composable
fun getGreetingMessage(): String {
    val currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    return when (currentHour) {
        in 6..11 -> "¡Buenos días!"
        in 12..17 -> "¡Buenas tardes!"
        else -> "¡Buenas noches!"
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}

