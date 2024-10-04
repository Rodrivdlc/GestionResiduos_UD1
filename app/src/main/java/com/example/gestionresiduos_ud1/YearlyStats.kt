package com.example.gestionresiduos_ud1.Periods

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gestionresiduos_ud1.Grafico.SimpleBarChart
import com.example.gestionresiduos_ud1.ui.theme.black
import com.example.gestionresiduos_ud1.ui.theme.suave

@Composable
fun YearlyStats(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth().height(200.dp).padding(8.dp),
        colors = CardDefaults.cardColors(contentColor = black)
    ) {
        Text("Gráfico de barras de residuos (año)", modifier = Modifier.padding(16.dp))
        SimpleBarChart(data = listOf(240f, 15f, 480f), labels = listOf("Reciclados", "Reducción", "Huella"))
    }
    Spacer(modifier = Modifier.height(16.dp))
    Card(
        modifier = Modifier.fillMaxWidth().height(200.dp).padding(8.dp),
        colors = CardDefaults.cardColors(contentColor = black)
    ) {
        Column(modifier = Modifier.padding(16.dp).verticalScroll(rememberScrollState())) {
            Text("Residuos Reciclados", style = MaterialTheme.typography.titleMedium)
            Text("valor: 240 kg", style = MaterialTheme.typography.bodyMedium)
            Text("Reducción de Residuos", style = MaterialTheme.typography.titleMedium)
            Text("valor: 15%", style = MaterialTheme.typography.bodyMedium)
            Text("Huella de Carbono", style = MaterialTheme.typography.titleMedium)
            Text("valor: 480 kg CO2", style = MaterialTheme.typography.bodyMedium)
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
    Text("Estadísticas de la Aplicación",
        style = MaterialTheme.typography.headlineMedium,
                color = suave)
    Card(
        modifier = Modifier.fillMaxWidth().height(200.dp).padding(8.dp),
        colors = CardDefaults.cardColors(contentColor = black)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Números de Descargas este año", style = MaterialTheme.typography.titleMedium)
            Text("valor: 300,000", style = MaterialTheme.typography.bodyMedium)
            Text("Máximo de usuarios activos de forma simultanea este año", style = MaterialTheme.typography.titleMedium)
            Text("valor: 150,000", style = MaterialTheme.typography.bodyMedium)
            Text("Incremento en la Tasa de Reciclaje este año", style = MaterialTheme.typography.titleMedium)
            Text("valor: 60%", style = MaterialTheme.typography.bodyMedium)
        }
    }
}