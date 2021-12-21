package com.example.bcsd_task5.FragmentFile

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bcsd_task5.R
import com.example.bcsd_task5.databinding.FragmentfileOneBinding

class FragmentOne: Fragment(){

    private var _binding:FragmentfileOneBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentfileOneBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val noteList = ArrayList<RecyclerData>()

        var number = 1
        binding.btnExtra.setOnClickListener {
            var resultText = binding.inputName.text.toString()
            noteList.apply {
                add(RecyclerData(resultText))
            }
            number += 1
            val adapter = RecyclerAdapter(noteList)
            binding.noteRecycler.adapter = adapter
            binding.noteRecycler.layoutManager = LinearLayoutManager(null)
//            binding.textView.text = resultText
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        _binding = null!!
    }

}