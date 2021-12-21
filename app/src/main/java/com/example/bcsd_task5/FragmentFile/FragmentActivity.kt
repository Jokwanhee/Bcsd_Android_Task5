package com.example.bcsd_task5.FragmentFile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.bcsd_task5.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class FragmentActivity : AppCompatActivity() {
    private val fragmentManager:FragmentManager = supportFragmentManager
    private val noteFragment = FragmentOne()
    private val calcFragment = FragmentTwo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        startBottomNavigation()
    }
    private fun startBottomNavigation() {
        val bottomNavi = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        fragmentManager
            .beginTransaction()
            .add(R.id.frame, calcFragment)
            .add(R.id.frame,noteFragment)
            .commit()

        bottomNavi.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_note_id -> {
                    fragmentManager
                        .beginTransaction()
                        .show(noteFragment)
                        .commit()
                    fragmentManager
                        .beginTransaction()
                        .hide(calcFragment)
                        .commit()
                    Toast.makeText(this, "Note", Toast.LENGTH_SHORT).show()
                }
                R.id.menu_calc_id -> {
                    fragmentManager
                        .beginTransaction()
                        .show(calcFragment)
                        .commit()
                    fragmentManager
                        .beginTransaction()
                        .hide(noteFragment)
                        .commit()
                    Toast.makeText(this, "Calculator", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }

}