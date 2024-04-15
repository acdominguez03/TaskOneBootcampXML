package com.example.taskonebootcampxml.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.taskonebootcampxml.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.btnChangeTexts.setOnClickListener {
            when(homeViewModel.randomNumber()) {
                0 -> binding.tvOne.text = homeViewModel.uiState.value.randomText
                1 ->  binding.tvTwo.text = homeViewModel.uiState.value.randomText
            }
        }

        return binding.root
    }
}