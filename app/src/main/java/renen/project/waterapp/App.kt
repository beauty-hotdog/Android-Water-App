package renen.project.waterapp

import android.app.Application
import renen.project.waterapp.notification.Notificator
import renen.project.waterapp.notification.NotificatorImpl

class App: Application() {

    val notificator: Notificator = NotificatorImpl()

    override fun onCreate() {
        super.onCreate()
    }
}