package com.example.bcsd_android_task5

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentOne : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentData = inflater.inflate(R.layout.fragement_one, container, false)
        val num = arguments?.getString("number")
        val numInt = arguments?.getInt("number_int") ?: 0
        val explanation = fragmentData.findViewById<TextView>(R.id.explanation_text)
        val numberText = fragmentData.findViewById<TextView>(R.id.second_text_number)
        val rand = java.util.Random()

        explanation.text = "Here is a random number between 0 and $num"
        numberText.text = rand.nextInt(numInt).toString()

        return fragmentData
    }
}