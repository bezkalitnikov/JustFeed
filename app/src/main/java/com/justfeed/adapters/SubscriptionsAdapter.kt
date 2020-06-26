package com.justfeed.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.justfeed.R
import com.justfeed.common.FeedSource
import com.justfeed.databinding.SubscriptionItemBinding

class SubscriptionsAdapter(private val feedSources: Array<FeedSource>) :
        RecyclerView.Adapter<SubscriptionsAdapter.ViewHolder>() {

    class ViewHolder(private val binding: SubscriptionItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: FeedSource) {
            binding.viewModel = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        inflater
            .inflate(R.layout.subscription_item, parent, false)
        val binding = SubscriptionItemBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(feedSources[position])
    }

    override fun getItemCount() = feedSources.size
}