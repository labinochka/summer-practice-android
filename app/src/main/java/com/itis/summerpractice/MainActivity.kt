package com.itis.summerpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    private var clickButton: Button? = null
    private var answer = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView2)
        clickButton = findViewById<Button>(R.id.button)

        val nameEdit = findViewById<EditText>(R.id.editTextNumber3)
        nameEdit.addTextChangedListener {
            if (nameEdit.text.length !in 1..50) {
                nameEdit.error = "Incorrect data"
            }
        }

        val ageEdit = findViewById<EditText>(R.id.editTextNumber2)
        ageEdit.addTextChangedListener {
            if ((ageEdit.text.toString() == "") || (ageEdit.text.toString().toInt() !in 1..149)) {
                ageEdit.error = "Incorrect data"
            }
        }

        val heightEdit = findViewById<EditText>(R.id.editTextNumber)
        heightEdit.addTextChangedListener {
            if ((heightEdit.text.toString() == "") || (heightEdit.text.toString().toInt() !in 1..249)) {
                heightEdit.error = "Incorrect data"
            }
        }

        val weightEdit = findViewById<EditText>(R.id.editTextNumberDecimal)
        weightEdit.addTextChangedListener {
            if ((weightEdit.text.toString() == "") ||(weightEdit.text.toString().toDouble() !in 1.0..249.0)) {
                weightEdit.error = "Incorrect data"
            }
        }

        clickButton?.setOnClickListener {
            val name = nameEdit.text
            val age = ageEdit.text.toString().toInt()
            val height = heightEdit.text.toString().toInt()
            val weight = weightEdit.text.toString().toDouble()
            answer = (name.length + age + height + weight + 1000).toInt()
            textView.text = "Answer: $answer"
        }
    }
}