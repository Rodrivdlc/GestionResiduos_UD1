package com.example.gestionresiduos_ud1.Grafico

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SimpleBarChart(data: List<Float>, labels: List<String>) {
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(200.dp)) {
        val barWidth = size.width / data.size
        val maxValue = data.maxOrNull() ?: 0f

        for (i in data.indices) {
            val barHeight = data[i] * size.height / maxValue
            drawRect(
                color = Color.Green,
                topLeft = Offset(i * barWidth, size.height - barHeight),
                size = Size(barWidth, barHeight)
            )


        }


    }
}