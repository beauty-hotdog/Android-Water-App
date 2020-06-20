package renen.project.waterapp.notification

import renen.project.database.logicentity.DrinkIntakeWithType

class NotificatorImpl : Notificator {

    val hourInMillis: Long = 3_600_000
    val fifteenMinutesInMillis: Long = 900_000

    override fun scheduleNotification(drinkIntake: DrinkIntakeWithType) {
        val timestamp = drinkIntake.drinkIntake.timestamp
        if (drinkIntake.drinkType.influence) {
            createNotification(timestamp + fifteenMinutesInMillis)
        } else {
            createNotification(timestamp + hourInMillis)
        }
    }

    private fun createNotification(timestamp: Long) {

    }
}