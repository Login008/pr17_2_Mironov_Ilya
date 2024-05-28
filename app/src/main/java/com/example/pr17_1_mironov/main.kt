package com.example.pr17_1_mironov

import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class main : AppCompatActivity() {
    private lateinit var pref: SharedPreferences
    private lateinit var back : LinearLayout
    private val MY_SETTINGS = "my_settings"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pref = getSharedPreferences(MY_SETTINGS, MODE_PRIVATE)
        back = findViewById<LinearLayout>(R.id.fon)
        val ed = pref.edit()
        var Index = pref.getInt("Index", 0)

        if (Index == 0)
        {
            back.setBackgroundColor(Color.parseColor("#FF0000"))
        }
        else if (Index == 1 || Index % 2 == 0)
        {
            back.setBackgroundColor(Color.parseColor("#0000ff"))
        }
        else
        {
            back.setBackgroundColor(Color.parseColor("#008000"))
        }
        Index++

        ed.putInt("Index", Index)
        ed.commit()
    }
}