package com.karthik.a.localbroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class CustomReceiver : BroadcastReceiver() {
    companion object{
         val ACTION_CUSTOM_BROADCAST = "com.karthik.a.localbroadcasr" + ".ACTION_CUSTOM_BROADCAST"
    }
    override fun onReceive(context: Context?, intent: Intent?) {
        val intentAction = intent?.action
        if(intentAction !=null){
            var toastMessage = "Unknown intent action"
            when(intentAction){
                Intent.ACTION_POWER_CONNECTED -> toastMessage = "Power connected"
                Intent.ACTION_POWER_DISCONNECTED -> toastMessage = "Power disconnected"
                ACTION_CUSTOM_BROADCAST -> toastMessage = intent.getStringExtra("DATA").toString()
            }
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
        }
    }
}