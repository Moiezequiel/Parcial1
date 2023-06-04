package com.test.app_cantante.data.Adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.test.app_cantante.data.Model.SingerModel
import com.test.app_cantante.databinding.FragmentSingerItemBinding

class SingerRecyclerViewHolder(private val binding: FragmentSingerItemBinding): RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(
        singer: SingerModel, clickListener: (SingerModel) -> Unit
    ) {
        binding.textViewName.text = singer.name
        binding.textViewMusicType.text = singer.music_type

        binding.cardItem.setOnClickListener {
            clickListener(singer)
        }
    }
}