package com.test.app_cantante.ui.home.SingerItem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.app_cantante.databinding.FragmentSingerItemBinding


/**
 Fragment show item singer
 */
class SingerItemFragment : Fragment() {
    private lateinit var binding: FragmentSingerItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSingerItemBinding.inflate(inflater, container, false)
        return binding.root
    }

}