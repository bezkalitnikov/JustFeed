package com.justfeed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.justfeed.databinding.FragmentNoFeedsBinding
import com.justfeed.viewmodels.MainViewModel

class NoFeedsFragment : Fragment() {

    private lateinit var binding: FragmentNoFeedsBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoFeedsBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel;
        viewModel.uiEventLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                MainViewModel.MainViewCommand.GoToSubscriptions -> {
                    val action = NoFeedsFragmentDirections.actionNoFeedsFragmentToSubscriptionsFragment()
                    findNavController().navigate(action)
                    viewModel.uiEventLiveData.value = null
                }
                else -> {
                }
            }
        })
        return binding.root
    }
}