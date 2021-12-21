package com.example.bcsd_task5.FragmentFile

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bcsd_task5.R
import com.example.bcsd_task5.databinding.FragmentfileOneBinding

class FragmentOne : Fragment() {

    private var _binding: FragmentfileOneBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentfileOneBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val noteList = ArrayList<RecyclerData>()
        val adapter = RecyclerAdapter(noteList)
        binding.noteRecycler.addItemDecoration(VerticalDecorator(10))
        binding.noteRecycler.addItemDecoration(HorizontalDecorator(10))

        binding.btnExtra.setOnClickListener {
            noteList.apply {
                var resultText = binding.inputName.text.toString()
                add(RecyclerData(resultText))
                binding.noteRecycler.adapter = adapter
                binding.noteRecycler.layoutManager = LinearLayoutManager(null)
                adapter.notifyDataSetChanged()
            }
        }

        adapter.setItemClickListener(object : RecyclerAdapter.OnItemClickListener {
            override fun onClick(v: View, position: Int) {
                val builder = AlertDialog.Builder(view.context)
                builder.setTitle(R.string.TOAST)
                builder.setMessage(R.string.message)
                builder.setPositiveButton(R.string.Positive) { dialog, which ->
                    noteList.removeAt(position)
                    adapter.notifyDataSetChanged()
                }
                builder.setNegativeButton(R.string.Negative) { dialog, which ->
                    Toast.makeText(view.context, "취소", Toast.LENGTH_SHORT).show()
                }
                builder.show()
            }
        })


    }

    override fun onDestroyView() {
        super.onDestroyView()
//        _binding = null!!
    }

}