package com.test.app_cantante.data.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.app_cantante.data.Model.SingerModel
import com.test.app_cantante.databinding.FragmentSingerItemBinding

class SingerRecyclerViewAdapter(
    private val clickListener: (SingerModel) -> Unit
): RecyclerView.Adapter<SingerRecyclerViewHolder>() {
    private val singers = ArrayList<SingerModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingerRecyclerViewHolder {
        val binding = FragmentSingerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SingerRecyclerViewHolder(binding)
    }

    override fun getItemCount() = singers.size

    override fun onBindViewHolder(holder: SingerRecyclerViewHolder, position: Int) {
        val singer = singers[position]
        holder.bind(singer, clickListener)
    }

    fun setData(singerList: List<SingerModel>){
        singers.clear()
        singers.addAll(singerList)
    }

}