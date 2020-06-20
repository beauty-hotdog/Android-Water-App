package renen.project.waterapp.notification

import renen.project.database.logicentity.DrinkIntakeWithType

interface Notificator {
    fun scheduleNotification(drinkIntake: DrinkIntakeWithType)
}