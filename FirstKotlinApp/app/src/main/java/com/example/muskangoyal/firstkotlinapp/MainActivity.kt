package com.example.muskangoyal.firstkotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
           Toast.makeText(this@MainActivity,"HELLO",Toast.LENGTH_SHORT).show();
            val result = et1.text.toString().toInt()+ et2.text.toString().toInt();
            tv.text= result.toString();
        }
    }
}
