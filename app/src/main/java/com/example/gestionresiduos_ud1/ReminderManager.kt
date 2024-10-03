package com.example.gestionresiduos_ud1

object ReminderManager {
    private val reminders = mutableListOf<Reminder>()

    fun saveReminder(reminder: Reminder) {
        reminders.add(reminder)
    }

    fun getRemindersForDate(date: Long): List<Reminder> {
        // Filter reminders by date (this is a placeholder, you should implement proper filtering)
        return reminders.filter { it.startTime == date }
    }

    fun getAllReminders(): List<Reminder> {
        return reminders
    }
}

data class Reminder(
    val description: String,
    val startTime: Long,
    val endTime: Long,
    val pickupPoint: String
)