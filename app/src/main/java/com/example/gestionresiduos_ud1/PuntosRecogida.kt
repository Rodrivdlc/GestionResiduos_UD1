package com.example.gestionresiduos_ud1

import android.content.Context
import android.widget.ImageButton

class PuntosRecogida(private val context: Context) {

    fun setupPoints(points: List<Pair<ImageButton, String>>, onPointSelected: (String) -> Unit) {
        points.forEach { (point, message) ->
            setupPoint(point, message, onPointSelected)
        }
    }

    private fun setupPoint(point: ImageButton, message: String, onPointSelected: (String) -> Unit) {
        point.setOnClickListener {
            onPointSelected(message)
        }
    }
}