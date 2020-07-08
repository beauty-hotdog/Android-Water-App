package renen.project.waterapp.notification

import android.content.Context
import io.karn.notify.Notify
import renen.project.database.logicentity.DrinkIntakeWithType

class NotificatorImpl : Notificator {

    val hourInMillis: Long = 3_600_000
    val fifteenMinutesInMillis: Long = 900_000

    override fun scheduleNotification(drinkIntake: DrinkIntakeWithType, context: Context) {
        val timestamp = drinkIntake.drinkIntake.timestamp
        if (drinkIntake.drinkType.influence) {
            createNotification(timestamp + fifteenMinutesInMillis, context)
        } else {
            createNotification(timestamp + hourInMillis, context)
        }
    }

    override fun debugNotification(context: Context) {
        createNotification(0L, context)
    }

    private fun createNotification(timestamp: Long, context: Context) {
        showNotification("Title", "Text", context)
    }

    private fun showNotification(titleText: String, description: String, context: Context){
        Notify
            .with(context)
            .content {
                title = titleText
                text = description
            }
            .show()
    }
}