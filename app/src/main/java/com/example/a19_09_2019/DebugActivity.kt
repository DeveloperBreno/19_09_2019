package com.example.a19_09_2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class DebugActivity : AppCompatActivity() {

    private val TAG = "LMSApp"
    private val className : String
        get(){

            val s = javaClass.name
            return s.substring(s.lastIndexOf("."))
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "$className.onCreate()")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "$className.onStart()")
    }

}
