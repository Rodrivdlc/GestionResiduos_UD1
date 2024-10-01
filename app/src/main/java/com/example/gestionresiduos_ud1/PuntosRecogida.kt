package com.example.gestionresiduos_ud1

import android.content.Context
import android.widget.ImageButton
import android.widget.Toast

class PuntosRecogida(private val context: Context) {

    fun setupPoints(points: List<Pair<ImageButton, String>>) {
        points.forEach { (point, message) ->
            setupPoint(point, message)
        }
    }

    private fun setupPoint(point: ImageButton, message: String) {
        point.setOnClickListener {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}