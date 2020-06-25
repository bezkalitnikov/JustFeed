package com.justfeed.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.justfeed.R
import com.justfeed.common.subscriptions.Subscription

class SubscriptionsAdapter(private val subscriptions: Array<Subscription>) :
        RecyclerView.Adapter<SubscriptionsAdapter.SubscriptionsViewHolder>() {

    class SubscriptionsViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriptionsViewHolder {
        var textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_subscriptions, parent, false) as TextView
        return SubscriptionsViewHolder(
            textView
        )
    }

    override fun onBindViewHolder(holder: SubscriptionsViewHolder, position: Int) {
        holder.textView.text = subscriptions[position].id
    }

    override fun getItemCount() = subscriptions.size
}