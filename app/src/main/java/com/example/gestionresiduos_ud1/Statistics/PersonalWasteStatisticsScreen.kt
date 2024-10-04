package com.example.gestionresiduos_ud1.Statistics

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gestionresiduos_ud1.Periods.MonthlyStats
import com.example.gestionresiduos_ud1.Periods.WeeklyStats
import com.example.gestionresiduos_ud1.Periods.YearlyStats
import com.example.gestionresiduos_ud1.ui.theme.black

@Composable
fun PersonalWasteStatisticsScreen(modifier: Modifier = Modifier) {

    var selectedPeriod by remember { mutableStateOf("Semana") }
    val periods = listOf("Semana", "Mes" , "Año")
    var expanded by remember { mutableStateOf(false) }


    Card(modifier = Modifier
        .padding(horizontal = 16.dp, vertical = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = black
        )
        ) {
        Text("Estadísticas Personales", style = MaterialTheme.typography.headlineSmall)


        Box (modifier = Modifier.padding(8.dp)) {
            Text(
                text = "Periodo: $selectedPeriod",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.clickable { expanded = true }

            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {

                periods.forEach { period ->
                    DropdownMenuItem(
                        text = { Text(period) },
                        onClick = {
                            selectedPeriod = period
                            expanded = false

                        }
                    )

                }

            }

        }

        when (selectedPeriod) {
            "Semana" -> WeeklyStats()
            "Mes" -> MonthlyStats()
            "Año" -> YearlyStats()
        }

    }
}