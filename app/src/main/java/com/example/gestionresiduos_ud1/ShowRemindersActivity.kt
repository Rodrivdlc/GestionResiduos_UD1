package com.example.gestionresiduos_ud1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import java.util.Date

class ShowRemindersActivity : AppCompatActivity() {

    private lateinit var remindersListView: ListView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_reminders)

        remindersListView = findViewById(R.id.remindersListView)
        backButton = findViewById(R.id.backButton)

        val reminders = ReminderManager.getAllReminders()
        val reminderDetails = reminders.map { reminder ->
            "Descripción: ${reminder.description}\nHora de inicio: ${Date(reminder.startTime)}\nHora de fin: ${Date(reminder.endTime)}\nPunto de recogida: ${reminder.pickupPoint}"
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, reminderDetails)
        remindersListView.adapter = adapter

        backButton.setOnClickListener {
            finish()
        }
    }
}