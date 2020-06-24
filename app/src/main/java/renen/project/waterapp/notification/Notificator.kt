package renen.project.waterapp.notification

import android.content.Context
import renen.project.database.logicentity.DrinkIntakeWithType

interface Notificator {
    fun scheduleNotification(drinkIntake: DrinkIntakeWithType, context: Context)
    fun debugNotification(context: Context)
}