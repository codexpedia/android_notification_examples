package com.example.notificationexamples

import android.app.NotificationManager
import android.widget.Toast
import android.content.Intent
import android.content.BroadcastReceiver
import android.content.Context
import com.example.notificationexamples.MainActivity.Companion.ACTION1
import com.example.notificationexamples.MainActivity.Companion.ACTION2
import com.example.notificationexamples.MainActivity.Companion.ACTION3


class ActionReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action === ACTION1) {
            Toast.makeText(context, "Action 1 Detected.", Toast.LENGTH_SHORT).show()
        } else if (intent.action === ACTION2) {
            Toast.makeText(context, "Action 2 Detected.", Toast.LENGTH_SHORT).show()
        } else if (intent.action === ACTION3) {
            Toast.makeText(context, "Action 3 Detected.", Toast.LENGTH_SHORT).show()
        }
    }

}