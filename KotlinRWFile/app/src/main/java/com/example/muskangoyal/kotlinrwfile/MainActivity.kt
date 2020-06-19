package com.example.muskangoyal.kotlinrwfile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       btn1.setOnClickListener {
           val datadir = ContextCompat.getDataDir(this)
           val myfile = File(datadir,"file.txt")
       myfile.writeText(et.text.toString())

//           var br = myfile.readLines()
//           while (br != null){
//               myfile.appendText(et.text.toString())
//               br= myfile.readLines()
//           }
       }

        btn2.setOnClickListener {
            val datadir = ContextCompat.getDataDir(this)
            val myfile = File(datadir,"file.txt")
            tv.text = myfile.readText()
        }
    }
}
