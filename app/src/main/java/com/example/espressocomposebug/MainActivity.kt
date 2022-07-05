package com.example.espressocomposebug

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        findViewById<View>(R.id.button_outside).setOnClickListener {
            Log.d("TRLOG ", "TRLOG **********************************")
            Log.d("TRLOG ", "TRLOG BUTTON OUTSIDE CLICKED")
            Log.d("TRLOG ", "TRLOG **********************************")
        }

    }
}
