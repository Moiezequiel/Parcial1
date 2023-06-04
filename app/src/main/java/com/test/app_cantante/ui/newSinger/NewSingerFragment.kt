package com.test.app_cantante.ui.newSinger

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.test.app_cantante.ui.viewModel.SingerViewModel
import com.test.app_cantante.databinding.FragmentNewSingerBinding

/**
This fragment works as form to add new singers
 */
class NewSingerFragment : Fragment() {

    private lateinit var binding: FragmentNewSingerBinding

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
        binding = FragmentNewSingerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setSingerViewModel()
        sentSingerStatus()
    }

    private fun sentSingerStatus() {
        singerViewModel.status.observe(viewLifecycleOwner){ status->
            when{
                status.equals(SingerViewModel.WRONG_INFORMATION)->{
                    val toast = Toast.makeText(requireContext(), SingerViewModel.WRONG_INFORMATION, Toast.LENGTH_SHORT)
                    toast.show()
                }
                status.equals(SingerViewModel.SINGER_ADDED)->{
                    val toast = Toast.makeText(requireContext(), SingerViewModel.SINGER_ADDED, Toast.LENGTH_SHORT)
                    toast.show()

                    singerViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

    private fun setSingerViewModel() {
        binding.viewmodel = singerViewModel
    }

}