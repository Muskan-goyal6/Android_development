package com.example.muskangoyal.dynamicbroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.BrokenBarrierException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val psr = PowerStateReceiver()
        val iFilter = IntentFilter().apply {
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(Intent.ACTION_POWER_DISCONNECTED)
        }

        registerReceiver(psr,iFilter)
    }

    inner class PowerStateReceiver : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent : Intent?) {
            Toast.makeText(this@MainActivity,"power state changed",Toast.LENGTH_SHORT).show()
            if(intent == null)return
            if(intent.action == Intent.ACTION_POWER_CONNECTED){
                Toast.makeText(this@MainActivity,"power is charging",Toast.LENGTH_SHORT).show()
                cl.setBackgroundColor(Color.GREEN)
            }
            if (intent.action == Intent.ACTION_POWER_DISCONNECTED){
                Toast.makeText(this@MainActivity,"power is disconnected",Toast.LENGTH_SHORT).show()
                cl.setBackgroundColor(Color.RED)
            }

        }

    }
}
