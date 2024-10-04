package com.example.gestionresiduos_ud1

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import java.util.*

@Composable
fun NameInputScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Ingresa tu nombre") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Button(
            onClick = {
                navController.navigate("menu_screen/$name")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Continuar")
        }
    }
}

@Composable
fun MenuScreen(navController: NavController, name: String) {
    val context = LocalContext.current
    val greeting = getGreetingMessage(name)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = greeting,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Button(
            onClick = {
                val intent = Intent(context, CalendarActivity::class.java)
                context.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text(text = "Añadir recordatorio")
        }

        Button(
            onClick = { navController.navigate("statistics_screen") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Ver estadísticas personales")
        }
    }
}

@Composable
fun getGreetingMessage(name: String): String {
    val currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    val greeting = when (currentHour) {
        in 6..11 -> "¡Buenos días"
        in 12..17 -> "¡Buenas tardes"
        else -> "¡Buenas noches"
    }
    return if (name.isNotEmpty()) "$greeting, $name!" else "$greeting!"
}

@Preview(showBackground = true)
@Composable
fun NameInputScreenPreview() {
    NameInputScreen(navController = rememberNavController())
}

@Preview(showBackground = true)
@Composable
fun MenuScreenPreview() {
    MenuScreen(navController = rememberNavController(), name = "Usuario")
}