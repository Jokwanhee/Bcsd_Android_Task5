package com.example.bcsd_task5.FragmentFile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bcsd_task5.R
import com.example.bcsd_task5.databinding.ActivityFragmentBinding.inflate
import org.w3c.dom.Text

class RecyclerAdapter(
    val itemList:ArrayList<RecyclerData>
): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val Name:TextView
        init{
            Name = itemView.findViewById(R.id.text_name)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Name.setText(itemList.get(position).name)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}