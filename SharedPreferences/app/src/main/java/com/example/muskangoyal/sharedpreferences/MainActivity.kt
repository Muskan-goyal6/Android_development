package com.example.muskangoyal.sharedpreferences

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sPref = getPreferences(Context.MODE_PRIVATE)
        var color = sPref.getInt("Colour",Color.WHITE)
        llBackground.setBackgroundColor(color)


        fun saveColor(color : Int){
            var editor = sPref.edit()
            editor.putInt("Colour",color)
            editor.apply()
        }

        btnred.setOnClickListener {
            llBackground.setBackgroundColor(Color.RED)
            saveColor(Color.RED)
        }
        btnblue.setOnClickListener {
            llBackground.setBackgroundColor(Color.BLUE)
            saveColor(Color.BLUE)
        }
        btngreen.setOnClickListener {
            llBackground.setBackgroundColor(Color.GREEN)
            saveColor(Color.GREEN)
        }
    }
}
