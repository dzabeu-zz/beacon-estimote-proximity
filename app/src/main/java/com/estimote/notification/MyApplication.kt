package com.estimote.notification

import android.app.Application
import com.estimote.notification.estimote.NotificationsManager
import com.estimote.proximity_sdk.api.EstimoteCloudCredentials

//
// Running into any issues? Drop us an email to: contact@estimote.com
//

class MyApplication : Application() {

    val cloudCredentials = EstimoteCloudCredentials("proximitypush-cwj", "daff658234e5a01abaa212498fb5a07d")

    fun enableBeaconNotifications() {

       // val notificationsManagergGoodBye = NotificationsManager(this,2)
       // notificationsManagergGoodBye.startMonitoring(1.0)

        val notificationsManager = NotificationsManager(this)
        notificationsManager.startMonitoring(2.0 )


    }

    fun enableNotificationForce() {
        val notificationsManager = NotificationsManager(this)
        notificationsManager.NotificationForce()
    }

}
