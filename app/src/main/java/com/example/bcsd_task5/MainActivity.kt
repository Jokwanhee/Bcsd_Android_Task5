package com.example.bcsd_task5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toastButton = findViewById<Button>(R.id.toast_button)
        val countButton = findViewById<Button>(R.id.count_button)
        val randomButton = findViewById<Button>(R.id.random_button)
        val textNumber = findViewById<TextView>(R.id.text_number)
        val fragmentOne = FragmentOne()
        val bundle: Bundle = Bundle()
        var number = 15

        toastButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle(R.string.TOAST)
            builder.setMessage(R.string.message)
            builder.setPositiveButton(R.string.Positive) { dialog, which ->
                number = 15
                textNumber.text = "15"
            }
            builder.setNeutralButton(R.string.Neutral) { dialog, which ->
                Toast.makeText(this, R.string.Toast_message, Toast.LENGTH_SHORT).show()
            }
            builder.setNegativeButton(R.string.Negative) { dialog, which ->
            }
            builder.show()
        }

        countButton.setOnClickListener {
            number += 1
            fragmentOne.arguments = bundle
            bundle.putString("number", number.toString())
            bundle.putInt("number_int", number)
            textNumber.text = number.toString()
        }

        randomButton.setOnClickListener {
            fragmentOne.arguments = bundle
            bundle.putString("number", number.toString())
            bundle.putInt("number_int", number)
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame, fragmentOne)
            fragmentTransaction.commit()
        }

    }
}