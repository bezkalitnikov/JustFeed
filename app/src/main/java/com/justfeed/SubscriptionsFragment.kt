package com.justfeed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justfeed.adapters.SubscriptionsAdapter
import com.justfeed.databinding.FragmentSubscriptionsBinding
import com.justfeed.viewmodels.MainViewModel

class SubscriptionsFragment : Fragment() {

    private lateinit var binding: FragmentSubscriptionsBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentSubscriptionsBinding.inflate(layoutInflater)
        viewManager = LinearLayoutManager(context)
        viewAdapter = SubscriptionsAdapter(
            viewModel.getFeedSources()
        )
        recyclerView = binding.subscriptionsRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
        return binding.root
    }
}