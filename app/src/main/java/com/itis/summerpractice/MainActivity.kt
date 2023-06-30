package com.itis.summerpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var clickButton: Button? = null
    private var answer = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView2)
        clickButton = findViewById<Button>(R.id.button)

        clickButton?.setOnClickListener {
            val name = findViewById<EditText>(R.id.editTextNumber3).text
            val age = findViewById<EditText>(R.id.editTextNumber2).text.toString().toInt()
            val height = findViewById<EditText>(R.id.editTextNumber).text.toString().toInt()
            val weight = findViewById<EditText>(R.id.editTextNumberDecimal).text.toString().toDouble()
            if (name.length in 1..50 && age in 1..149 &&
                height in 1..249 && weight in 1.0..249.0) {
                answer = (name.length + age + height + weight + 1000).toInt()
                textView.text = "Answer: $answer"
            } else {
                textView.text = "Incorrect data"
            }
        }
    }
}