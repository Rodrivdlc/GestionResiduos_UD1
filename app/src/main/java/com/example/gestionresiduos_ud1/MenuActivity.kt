// src/main/java/com/example/gestionresiduos_ud1/MenuActivity.kt
package com.example.gestionresiduos_ud1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class MenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val buttonMainActivity: Button = findViewById(R.id.buttonMainActivity)
        val buttonCalendarActivity: Button = findViewById(R.id.buttonCalendarActivity)

        buttonMainActivity.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        buttonCalendarActivity.setOnClickListener {
            val intent = Intent(this, CalendarActivity::class.java)
            startActivity(intent)
        }
    }
}