package com.justfeed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.justfeed.databinding.FragmentFeedsBinding
import com.justfeed.viewmodels.MainViewModel

class FeedsFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentFeedsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFeedsBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        if (!viewModel.getSubscriptions().any()) {
            navController.navigate(R.id.noFeedsFragment)
        }
    }
}