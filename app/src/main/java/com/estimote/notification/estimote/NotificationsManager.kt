package com.estimote.notification.estimote

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.support.v4.app.NotificationCompat
import android.util.Log
import com.estimote.proximity_sdk.api.ProximityObserverBuilder
import com.estimote.proximity_sdk.api.ProximityZoneBuilder

import android.widget.RemoteViews
import com.estimote.notification.*
import android.graphics.Bitmap

//
// Running into any issues? Drop us an email to: contact@estimote.com
//

class NotificationsManager(private val context: Context) {

    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    private fun buildNotification(): Notification {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(NotificationChannel(
                    "content_channel", "Things near you", NotificationManager.IMPORTANCE_HIGH))
        }
        val view_1: RemoteViews
        view_1 = RemoteViews(context.getPackageName(), R.layout.custom_notif_wel1)
        val view_2: RemoteViews
        view_2 = RemoteViews(context.getPackageName(), R.layout.custom_notif_wel2)

        return NotificationCompat.Builder(context, "content_channel")
                    .setSmallIcon(android.R.drawable.ic_dialog_info)
                    .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),R.drawable.icon_notification))
                    .setStyle(NotificationCompat.DecoratedCustomViewStyle())
                    .setCustomContentView(view_1)
                    .setCustomBigContentView(view_2)
                    .setContentIntent(PendingIntent.getActivity(context, 0,
                            Intent(context, Promo::class.java  ), PendingIntent.FLAG_UPDATE_CURRENT))
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setAutoCancel(true)
                    .build()
    }

    private fun buildNotificationGoodBye(): Notification {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(NotificationChannel(
                    "content_channel", "Things near you", NotificationManager.IMPORTANCE_HIGH))
        }
        val view_1: RemoteViews
        view_1 = RemoteViews(context.getPackageName(), R.layout.custom_notif_bye1)
        val view_2: RemoteViews
        view_2 = RemoteViews(context.getPackageName(), R.layout.custom_notif_bye2)

        // .setContentTitle(t itle)
        // .setContentText(text)
        return NotificationCompat.Builder(context, "content_channel")
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),
                        R.drawable.icon_notification))
                .setStyle(NotificationCompat.DecoratedCustomViewStyle())
                .setCustomContentView(view_1)
                .setCustomBigContentView(view_2)
                .setContentIntent(PendingIntent.getActivity(context, 0,
                        Intent(context, QRCode::class.java  ), PendingIntent.FLAG_UPDATE_CURRENT))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true)
                .build()

    }
    fun startMonitoring(range:Double) {

        val proximityObserver = ProximityObserverBuilder(context, (context as MyApplication).cloudCredentials)
                .onError { throwable ->
                    Log.e("app", "proximity observer error: $throwable")
                }
                .withBalancedPowerMode()
                .build()

        val zone = ProximityZoneBuilder()
                .forTag("proximitypush-cwj")
                .inCustomRange(range)
                .onEnter {
                        notificationManager.notify(1, buildNotification())
               }
                .onExit {
                       notificationManager.notify(1, buildNotificationGoodBye ())
                }
                .build()
        proximityObserver.startObserving(zone)

    }

    fun NotificationForce() {

        notificationManager.notify(1, buildNotification())

    }

}
