package com.example.bottomnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val displayText = intent.getStringExtra("listValue")
        if (displayText != null) {
            textView4.text = displayText
        } else {
            textView4.text = "This is Second Page"

        }

    }



    fun backButtonTapped (view: View) {
        onBackPressed()
    }
}