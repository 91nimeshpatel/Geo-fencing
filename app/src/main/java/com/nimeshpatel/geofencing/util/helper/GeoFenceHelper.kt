package com.nimeshpatel.geofencing.util.helper

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import com.google.android.gms.location.Geofence
import com.google.android.gms.location.GeofencingRequest
import com.google.android.gms.maps.model.LatLng
import com.nimeshpatel.geofencing.util.receiver.GeofenceBroadcastReceiver

class GeoFenceHelper(val context: Context) {

    fun getGeofence(id: String, latLng: LatLng, radius: Float, transitionTypes: Int): Geofence {
        return Geofence.Builder()
            .setRequestId(id)
            .setCircularRegion(latLng.latitude, latLng.longitude, radius)
            .setTransitionTypes(transitionTypes)
            .setLoiteringDelay(5000) // 30 seconds
            .setExpirationDuration(Geofence.NEVER_EXPIRE)
            .build()
    }

    fun getGeofencingRequest(geofence: Geofence): GeofencingRequest {
        return GeofencingRequest.Builder()
            .setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER)
            .addGeofence(geofence)
            .build()
    }

    fun getPendingIntent(): PendingIntent {
        val intent = Intent(context, GeofenceBroadcastReceiver::class.java)
        return PendingIntent.getBroadcast(
            context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_MUTABLE
        )
    }

    fun getErrorString(e: Exception): String {
        Log.e("GeofenceHelper", "Error: ${e.message}")
        return e.message.toString()
    }
}
