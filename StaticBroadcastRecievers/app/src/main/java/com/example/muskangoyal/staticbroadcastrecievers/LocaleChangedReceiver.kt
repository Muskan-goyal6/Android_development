package com.example.muskangoyal.staticbroadcastrecievers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class LocaleChangedReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {


        Log.d("RCV","Locale")
        Toast.makeText(context,"language changed",Toast.LENGTH_SHORT).show()
      //context.startActivity(Intent(context,MainActivity::class.java))
    }
}
