package com.test.app_cantante.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.app_cantante.data.Adapter.SingerRecyclerViewAdapter
import com.test.app_cantante.data.Model.SingerModel
import com.test.app_cantante.R
import com.test.app_cantante.ui.viewModel.SingerViewModel
import com.test.app_cantante.databinding.FragmentHomeBinding

/**
 This fragment works as home view from the application
 */
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: SingerRecyclerViewAdapter

    private val singerViewModel: SingerViewModel by activityViewModels{
        SingerViewModel.Factory
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                onBackPressed()
            }
        })

        appListeners()
        singerRecyclerView(view)
    }

    //creates recycler view and bind it to the holder element
    private fun singerRecyclerView(view: View) {
        binding.recyleViewSinger.layoutManager = LinearLayoutManager(view.context)

        adapter = SingerRecyclerViewAdapter { selectedSinger ->
            showSelectedSinger(selectedSinger)
        }

        binding.recyleViewSinger.adapter = adapter
        displayAllSingers()
    }

    //shows all singers in recycler
    private fun displayAllSingers() {
        adapter.setData(singerList = singerViewModel.getSingers())
        adapter.notifyDataSetChanged()
    }
    //shows only the selected singer
    private fun showSelectedSinger(selectedSinger: SingerModel) {

        singerViewModel.setSelectedSinger(selectedSinger)
        findNavController().navigate(R.id.action_homeFragment_to_singerDetailFragment)
    }

    //allows navigation to form
    private fun appListeners() {
        binding.btnAddEmployee.setOnClickListener{
            singerViewModel.clearData()
            it.findNavController().navigate(R.id.action_homeFragment_to_newSingerFragment)
        }
    }

    private fun onBackPressed(){
        val navController = Navigation.findNavController(requireView())
        if(navController.currentDestination?.id != R.id.homeFragment){
            navController.popBackStack()
        }
        else requireActivity().onBackPressed()
    }


}