package com.nimeshpatel.geofencing.util.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.google.android.gms.location.Geofence
import com.google.android.gms.location.GeofencingEvent
import com.nimeshpatel.geofencing.util.helper.NotificationHelper
import com.nimeshpatel.geofencing.view.home.HomeActivity

/**
 * Created by Nimesh Patel on 05-Jun-24.
 * Purpose:
 */
class GeofenceBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.e(TAG, "onReceive: ")
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        val notificationHelper = NotificationHelper(context)
        val geofencingEvent = GeofencingEvent.fromIntent(intent)

        if (geofencingEvent?.hasError() == true) {
            Log.d(TAG, "onReceive: Error receiving geofence event...")
            return
        }

        val geofenceList = geofencingEvent?.triggeringGeofences
        geofenceList?.forEach { geofence ->
            Log.d(TAG, "onReceive: ${geofence.requestId}")
        }

        val transitionType = geofencingEvent?.geofenceTransition
        when (transitionType) {
            Geofence.GEOFENCE_TRANSITION_ENTER -> {
                Log.d(TAG, "onReceive: GEOFENCE_TRANSITION_ENTER")
                Toast.makeText(context, "GEOFENCE_TRANSITION_ENTER", Toast.LENGTH_SHORT).show()
                notificationHelper.sendHighPriorityNotification(
                    "GEOFENCE_TRANSITION_ENTER", "", HomeActivity::class.java
                )
            }

            Geofence.GEOFENCE_TRANSITION_DWELL -> {
                Log.d(TAG, "onReceive: GEOFENCE_TRANSITION_DWELL")
                Toast.makeText(context, "GEOFENCE_TRANSITION_DWELL", Toast.LENGTH_SHORT).show()
                notificationHelper.sendHighPriorityNotification(
                    "GEOFENCE_TRANSITION_DWELL", "", HomeActivity::class.java
                )
            }

            Geofence.GEOFENCE_TRANSITION_EXIT -> {
                Log.d(TAG, "onReceive: GEOFENCE_TRANSITION_EXIT")
                Toast.makeText(context, "GEOFENCE_TRANSITION_EXIT", Toast.LENGTH_SHORT).show()
                notificationHelper.sendHighPriorityNotification(
                    "GEOFENCE_TRANSITION_EXIT", "", HomeActivity::class.java
                )
            }
        }
    }

    companion object {
        private const val TAG = "GeofenceBroadcastReceiver"
    }
}