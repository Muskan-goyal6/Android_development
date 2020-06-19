package com.example.muskangoyal.dynamicfragments

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnfruits.setOnClickListener {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragcontainer,FruitsFragment())
                    .commit()
        }

        btnvege.setOnClickListener {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragcontainer,VegetablesFragment())
                    .commit()
        }
    }
}
