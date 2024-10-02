package com.example.gestionresiduos_ud1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color


val GreenNeutral = Color(0xFFB7E061)
val suave = Color(0xFFF6D5D5)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ...
        setContent {
            App()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    var currentScreen by remember { mutableStateOf(Screen.PersonalWasteStatistics) }

    Scaffold(modifier = Modifier
        .fillMaxSize()
        .background(GreenNeutral),
        topBar = {
            TopAppBar(
            title = {
                Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text("Estadísticas")
            }
                 },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = GreenNeutral,
            )
        ) }) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).background(suave)) {
            Spacer(modifier = Modifier.height(16.dp))
            when (currentScreen) {
                Screen.PersonalWasteStatistics -> PersonalWasteStatisticsScreen(
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}

enum class Screen {
    PersonalWasteStatistics,
}


@Composable
fun PersonalWasteStatisticsScreen(modifier: Modifier = Modifier) {


    Column(modifier = Modifier
        .padding(horizontal = 16.dp, vertical = 16.dp)
        .background(GreenNeutral)) {
        Text("Estadísticas Personales", style = MaterialTheme.typography.headlineMedium)


        Card(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(8.dp),
            colors = CardDefaults.cardColors(containerColor = suave)) {

            // Aquí puedes usar una biblioteca de gráficos como MPAndroidChart para crear un gráfico real

            Text("Gráfico de barras de residuos por tipo" , modifier = Modifier.padding(16.dp))

        }

        Spacer(modifier = Modifier.height(16.dp))

            Card(modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(8.dp),
                colors = CardDefaults.cardColors(containerColor = suave))   {
                Column(modifier = Modifier.padding(16.dp)) {

                    Text("Residuos Reciclados" , style = MaterialTheme.typography.titleMedium)
                    Text("valor: 25kg (esta semana) " , style = MaterialTheme.typography.bodyMedium)

                    Text("Reducción de Residuos" , style = MaterialTheme.typography.titleMedium)
                    Text("valor: 10€ (en comparación con el mes pasado) " , style = MaterialTheme.typography.bodyMedium)

                    Text("Huella de Carbono" , style = MaterialTheme.typography.titleMedium)
                    Text("valor: 300 kg CO2 (este mes) " , style = MaterialTheme.typography.bodyMedium)

                }
            }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Estadísticas de la Aplicación", style = MaterialTheme.typography.headlineMedium)

        Card(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(8.dp),
            colors = CardDefaults.cardColors(containerColor = suave))   {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Números de Descargas" , style = MaterialTheme.typography.titleMedium)
                Text("valor: 10,000+ " , style = MaterialTheme.typography.bodyMedium)

                Text("Usuarios Activos Mensuales" , style = MaterialTheme.typography.titleMedium)
                Text("valor: 5,000+ " , style = MaterialTheme.typography.bodyMedium)

                Text("Incremento en la Tasa de Reciclaje" , style = MaterialTheme.typography.titleMedium)
                Text("valor: 15% " , style = MaterialTheme.typography.bodyMedium)

            }
        }
    }
}






