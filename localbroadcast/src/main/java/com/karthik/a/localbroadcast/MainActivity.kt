package com.karthik.a.localbroadcast

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class MainActivity : AppCompatActivity() {

    private val mReceiver = CustomReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Register the receiver
        LocalBroadcastManager.getInstance(this)
            .registerReceiver(mReceiver, IntentFilter(CustomReceiver.ACTION_CUSTOM_BROADCAST))

        val button = findViewById<Button>(R.id.btnSendBroadcast)
        button.setOnClickListener {
            sendBroadCast()
        }
    }

    private fun sendBroadCast(){
        val intent = Intent(CustomReceiver.ACTION_CUSTOM_BROADCAST)
        intent.putExtra("DATA", "Hi Karthik yu are great")
        // Send the local broadcast
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        // Unregister the receiver to avoid memory leaks
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver)
    }
}