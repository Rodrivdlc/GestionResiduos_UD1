package com.example.gestionresiduos_ud1

import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class AddReminderActivity : AppCompatActivity() {

    private lateinit var descriptionEditText: EditText
    private lateinit var startTimeButton: Button
    private lateinit var endTimeButton: Button
    private lateinit var pickupPointButton: Button
    private lateinit var saveButton: Button
    private lateinit var backButton: Button
    private var startTime: Calendar = Calendar.getInstance()
    private var endTime: Calendar = Calendar.getInstance()
    private var selectedPickupPoint: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_reminder)

        descriptionEditText = findViewById(R.id.descriptionEditText)
        startTimeButton = findViewById(R.id.startTimeButton)
        endTimeButton = findViewById(R.id.endTimeButton)
        pickupPointButton = findViewById(R.id.pickupPointButton)
        saveButton = findViewById(R.id.saveButton)
        backButton = findViewById(R.id.backButton)

        startTimeButton.setOnClickListener {
            showTimePickerDialog(startTime) { time ->
                startTime = time
                startTimeButton.text = "${time.get(Calendar.HOUR_OF_DAY)}:${time.get(Calendar.MINUTE)}"
            }
        }

        endTimeButton.setOnClickListener {
            showTimePickerDialog(endTime) { time ->
                endTime = time
                endTimeButton.text = "${time.get(Calendar.HOUR_OF_DAY)}:${time.get(Calendar.MINUTE)}"
            }
        }

        pickupPointButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivityForResult(intent, REQUEST_PICKUP_POINT)
        }

        saveButton.setOnClickListener {
            val description = descriptionEditText.text.toString()
            val pickupPoint = selectedPickupPoint

            if (description.isEmpty() || pickupPoint == null || startTimeButton.text == "Hora de inicio" || endTimeButton.text == "Hora de fin") {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            } else if (startTime.after(endTime)) {
                Toast.makeText(this, "La hora de inicio debe ser antes que la hora de fin", Toast.LENGTH_SHORT).show()
            } else {
                val reminder = Reminder(description, startTime.timeInMillis, endTime.timeInMillis, pickupPoint)
                ReminderManager.saveReminder(reminder)

                Toast.makeText(this, "Recordatorio guardado", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        backButton.setOnClickListener {
            finish()
        }
    }

    private fun showTimePickerDialog(calendar: Calendar, onTimeSet: (Calendar) -> Unit) {
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        TimePickerDialog(this, { _, selectedHour, selectedMinute ->
            calendar.set(Calendar.HOUR_OF_DAY, selectedHour)
            calendar.set(Calendar.MINUTE, selectedMinute)
            onTimeSet(calendar)
        }, hour, minute, true).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_PICKUP_POINT && resultCode == RESULT_OK) {
            selectedPickupPoint = data?.getStringExtra(EXTRA_PICKUP_POINT)
            pickupPointButton.text = selectedPickupPoint
        }
    }

    companion object {
        const val REQUEST_PICKUP_POINT = 1
        const val EXTRA_PICKUP_POINT = "extra_pickup_point"
    }
}