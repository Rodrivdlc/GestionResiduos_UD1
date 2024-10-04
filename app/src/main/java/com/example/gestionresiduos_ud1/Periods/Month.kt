package com.example.gestionresiduos_ud1.Periods

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gestionresiduos_ud1.suave

@Composable
fun MonthlyStats(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = suave)
    ) {
        Text("Gráfico de barras de residuos mes", modifier = Modifier.padding(16.dp))
    }
    Spacer (modifier = Modifier.height(16.dp))



    Card (modifier = Modifier
        .fillMaxWidth()
        .height(200.dp)
        .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = suave)) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text("Residuos Reciclados", style = MaterialTheme.typography.titleMedium)
            Text("valor: 25kg (esta semana) ", style = MaterialTheme.typography.bodyMedium)

            Text("Reducción de Residuos", style = MaterialTheme.typography.titleMedium)
            Text(
                "valor: 10€ (en comparación con el mes pasado) ",
                style = MaterialTheme.typography.bodyMedium
            )

            Text("Huella de Carbono", style = MaterialTheme.typography.titleMedium)
            Text("valor: 300 kg CO2 (este mes) ", style = MaterialTheme.typography.bodyMedium)

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
