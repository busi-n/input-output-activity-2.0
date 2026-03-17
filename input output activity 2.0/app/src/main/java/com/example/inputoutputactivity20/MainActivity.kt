package com.example.inputoutputactivity20

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // get the button using the id we set on the user interface
        val clickMeButton = findViewById<Button>(R.id.clickMeButton)
        var displayTxt =findViewById<TextView>(R.id.displayTxt)
        val nameTxt = findViewById<EditText>(R.id.nameTxt)
        val zuluSwitch = findViewById<Switch>(R.id.zuluSwitch)

        //add code to the button that happens when its clicked
        clickMeButton?.setOnClickListener {
            var greeting: String
            var zulu: Boolean= zuluSwitch.isChecked
            if (zulu) {
                greeting= "Sawubona, ${nameTxt.text}!"
            } else {
                //easter egg for Sam
                if(nameTxt.text.toString() == "Sam"||
                    nameTxt.text.toString() == "Samatha") {
                    greeting = "Yo,${nameTxt.text}!"
                } else{
                    greeting= "Greetings,${nameTxt.text}!"
                }
                greeting = "Welcome, ${nameTxt.text}!"
            }
            if (zuluSwitch.isChecked) {
                greeting = "Sawubona,${nameTxt.text}!"
            }else{
                greeting = "Welcome,${nameTxt.text}!"
            }
            displayTxt.text = greeting
           Toast.makeText(this@MainActivity,
               "Button clicked", Toast.LENGTH_LONG).show()
            displayTxt.text = "Welcome,${nameTxt.text}!"

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}