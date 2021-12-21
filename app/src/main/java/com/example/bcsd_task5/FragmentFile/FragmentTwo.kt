package com.example.bcsd_task5.FragmentFile

import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bcsd_task5.R
import com.example.bcsd_task5.databinding.FragmentfileOneBinding
import com.example.bcsd_task5.databinding.FragmentfileTwoBinding

class FragmentTwo :Fragment(){

    private var _binding: FragmentfileTwoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentfileTwoBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var numArray = mutableListOf<Int>()
        var newArray = mutableListOf<String>()
        var charArray = mutableListOf<Int>()
        var num = "0"
        var result = 0

        binding.btnAc.setOnClickListener {
            numArray = mutableListOf<Int>()
            newArray = mutableListOf<String>()
            charArray = mutableListOf<Int>()
            result = 0
            binding.cNumber.setText("0")
        }

        binding.btnPlus.setOnClickListener {
            numArray = mutableListOf<Int>()
            charArray.add(43) // 43 -> +
            newArray.add(num)
            binding.cNumber.setText("+")
        }
        binding.btnMinus.setOnClickListener {
            numArray = mutableListOf<Int>()
            charArray.add(45) // 45 -> -
            newArray.add(num)
            binding.cNumber.setText("-")
        }
        binding.btnMulti.setOnClickListener {
            numArray = mutableListOf<Int>()
            charArray.add(42) // 42 -> *
            newArray.add(num)
            binding.cNumber.setText("*")
        }
        binding.btnDivide.setOnClickListener {
            numArray = mutableListOf<Int>()
            charArray.add(47) // 47 -> /
            newArray.add(num)
            binding.cNumber.setText("/")
        }
        binding.btnRest.setOnClickListener {
            numArray = mutableListOf<Int>()
            charArray.add(37) // 37 -> /
            newArray.add(num)
            binding.cNumber.setText("%")
        }

        binding.btnEquals.setOnClickListener {
            numArray = mutableListOf<Int>()
            charArray.add(61) // 61 -> =
            newArray.add(num)

            result = newArray.removeFirst().toInt()

            for (i in 0 until newArray.size){
                if (charArray[i].toChar() == '+'){
                    result = result + newArray[i].toInt()
                }
                else if (charArray[i].toChar() == '-'){
                    result = result - newArray[i].toInt()
                }
                else if (charArray[i].toChar() == '*'){
                    result = result * newArray[i].toInt()
                }
                else if (charArray[i].toChar() == '/'){
                    result = result / newArray[i].toInt()
                }
                else if (charArray[i].toChar() == '%'){
                    result = result % newArray[i].toInt()
                }

            }
            binding.cNumber.text = result.toString()
        }

        binding.btn1.setOnClickListener {
            numArray.add(1)
            num = numArray.joinToString("")
            binding.cNumber.text = num
        }
        binding.btn2.setOnClickListener {
            numArray.add(2)
            num = numArray.joinToString("")
            binding.cNumber.text = num
        }
        binding.btn3.setOnClickListener {
            numArray.add(3)
            num = numArray.joinToString("")
            binding.cNumber.text = num
        }
        binding.btn4.setOnClickListener {
            numArray.add(4)
            num = numArray.joinToString("")
            binding.cNumber.text = num
        }
        binding.btn5.setOnClickListener {
            numArray.add(5)
            num = numArray.joinToString("")
            binding.cNumber.text = num
        }
        binding.btn6.setOnClickListener {
            numArray.add(6)
            num = numArray.joinToString("")
            binding.cNumber.text = num
        }
        binding.btn7.setOnClickListener {
            numArray.add(7)
            num = numArray.joinToString("")
            binding.cNumber.text = num
        }
        binding.btn8.setOnClickListener {
            numArray.add(8)
            num = numArray.joinToString("")
            binding.cNumber.text = num
        }
        binding.btn9.setOnClickListener {
            numArray.add(9)
            num = numArray.joinToString("")
            binding.cNumber.text = num
        }
        binding.btn0.setOnClickListener {
            if (numArray.isEmpty()){
                binding.cNumber.text = "0"
            }
            else{
                numArray.add(0)
                num = numArray.joinToString("")
                binding.cNumber.text = num
            }
        }

    }
}