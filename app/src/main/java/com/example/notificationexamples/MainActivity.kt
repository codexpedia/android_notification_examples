package com.example.notificationexamples

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.widget.RemoteViews
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val ACTION1 = "com.example.notificationexamples.action1"
        val ACTION2 = "com.example.notificationexamples.action2"
        val ACTION3 = "com.example.notificationexamples.action3"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_default_view.setOnClickListener {
            val mBuilder = NotificationCompat.Builder(this, "default")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("A simple notification")
                    .setContentText("Swipe to dismiss it")
                    .setAutoCancel(true)

            val notification = mBuilder.build()
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(1, notification)
        }


        btn_default_view_activity_intent.setOnClickListener {
            val backToAppIntent = Intent(this, MainActivity::class.java)
            val pendingIntentBackToApp = PendingIntent.getActivity(this, 2222, backToAppIntent, PendingIntent.FLAG_UPDATE_CURRENT)
            val mBuilder = NotificationCompat.Builder(this, "default")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Intent Notification")
                    .setContentText("Multi lines content text. Back to app. Back to app. Back to app. Back to app. Back to app. Back to app. Back to app. Back to app.")
                    .setStyle(NotificationCompat.BigTextStyle().bigText("Multi lines content text. Back to app. Back to app. Back to app. Back to app. Back to app. Back to app. Back to app. Back to app."))
                    .setContentIntent(pendingIntentBackToApp)

            val notification = mBuilder.build()
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(2, notification)
        }


        btn_default_view_actions.setOnClickListener {

            val action1Intent = Intent()
            action1Intent.action = ACTION1
            val pendingIntentAction1 = PendingIntent.getBroadcast(this, 12345, action1Intent, PendingIntent.FLAG_UPDATE_CURRENT)
            val action1 = NotificationCompat.Action.Builder(R.drawable.ic_adb_black_24dp, "Action 1", pendingIntentAction1).build()


            val action2Intent = Intent()
            action1Intent.action = ACTION2
            val pendingIntentAction2 = PendingIntent.getBroadcast(this, 123456, action2Intent, PendingIntent.FLAG_UPDATE_CURRENT)
            val action2 = NotificationCompat.Action.Builder(R.drawable.ic_android_black_24dp, "Action 2", pendingIntentAction2).build()


            val mBuilder = NotificationCompat.Builder(this, "default")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Action notification")
                    .setContentText("Click the action buttons below.")
//                    .setOngoing(true)
                    .addAction(action1)
                    .addAction(action2)

            val notification = mBuilder.build()
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(3, notification)
        }

        btn_custom_view.setOnClickListener {

            val action3Intent = Intent()
            action3Intent.action = ACTION3
            val pendingIntentAction3 = PendingIntent.getBroadcast(this, 1234567, action3Intent, PendingIntent.FLAG_UPDATE_CURRENT)

            val contentView = RemoteViews(packageName, R.layout.notification_layout)
            contentView.setOnClickPendingIntent(R.id.btn_click, pendingIntentAction3)

            val mBuilder = NotificationCompat.Builder(this, "default")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("collapsed title")
                    .setContentText("collapsed text")
                    .setCustomBigContentView(contentView)

            val notification = mBuilder.build()
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(4, notification)
        }

    }
}
