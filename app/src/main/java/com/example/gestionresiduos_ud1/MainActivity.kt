package com.example.gestionresiduos_ud1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import com.example.gestionresiduos_ud1.Statistics.PersonalWasteStatisticsScreen
import com.example.gestionresiduos_ud1.ui.theme.black
import com.example.gestionresiduos_ud1.ui.theme.suave


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
        .background(black),
        topBar = {
            TopAppBar(
            title = {
                Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Text("Estadísticas")
            }
                 },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = black,
                titleContentColor = suave
            )
        ) }) { innerPadding ->
        Card (modifier = Modifier.padding(innerPadding),
            colors = CardDefaults.cardColors(
                contentColor = suave)
            ) {
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














