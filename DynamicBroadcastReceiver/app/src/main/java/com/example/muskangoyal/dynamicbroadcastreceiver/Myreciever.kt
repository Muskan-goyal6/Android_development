package com.example.muskangoyal.dynamicbroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class Myreciever : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        if(intent!=null &&  intent.action==Intent.ACTION_AIRPLANE_MODE_CHANGED){
                val airplanemode =intent.getBooleanExtra("state",false)
                Toast.makeText(context,"mode changed",Toast.LENGTH_SHORT).show()
                Log.d("RCV","onRecieve:"+airplanemode)
        }

    }
}