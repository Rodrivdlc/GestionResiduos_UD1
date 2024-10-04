package com.example.gestionresiduos_ud1

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val point1: ImageButton = findViewById(R.id.point1)
        val point2: ImageButton = findViewById(R.id.point2)
        val point3: ImageButton = findViewById(R.id.point3)

        val points = listOf(
            Pair(point1, "Punto de recogida 1"),
            Pair(point2, "Punto de recogida 2"),
            Pair(point3, "Punto de recogida 3")
        )

        val puntosRecogida = PuntosRecogida(this)
        puntosRecogida.setupPoints(points) { selectedPoint ->
            val resultIntent = Intent()
            resultIntent.putExtra(AddReminderActivity.EXTRA_PICKUP_POINT, selectedPoint)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}