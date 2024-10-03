package com.example.gestionresiduos_ud1

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class CalendarActivity : AppCompatActivity() {

    private lateinit var calendarView: CalendarView
    private lateinit var addReminderButton: Button
    private lateinit var showRemindersButton: Button
    private var selectedDate: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        calendarView = findViewById(R.id.calendarView)
        addReminderButton = findViewById(R.id.addReminderButton)
        showRemindersButton = findViewById(R.id.showRemindersButton)

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val calendar = Calendar.getInstance()
            calendar.set(year, month, dayOfMonth)
            selectedDate = calendar.timeInMillis

            val reminders = ReminderManager.getRemindersForDate(selectedDate)
            if (reminders.isNotEmpty()) {
                val reminderDetails = reminders.joinToString("\n") { reminder ->
                    "Descripción: ${reminder.description}\nHora de inicio: ${Date(reminder.startTime)}\nHora de fin: ${Date(reminder.endTime)}\nPunto de recogida: ${reminder.pickupPoint}"
                }
                Toast.makeText(this, reminderDetails, Toast.LENGTH_LONG).show()
            }
        }

        addReminderButton.setOnClickListener {
            if (selectedDate != 0L) {
                val intent = Intent(this, AddReminderActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, selecciona una fecha", Toast.LENGTH_SHORT).show()
            }
        }

        showRemindersButton.setOnClickListener {
            val intent = Intent(this, ShowRemindersActivity::class.java)
            startActivity(intent)
        }
    }
}