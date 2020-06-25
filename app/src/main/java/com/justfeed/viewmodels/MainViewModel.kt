package com.justfeed.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.justfeed.common.subscriptions.Subscription

class MainViewModel : ViewModel() {
    private val subscript: List<Subscription> by lazy {
        com.justfeed.common.subscriptions.getSubscriptions();
    }

    enum class MainViewCommand {
        GoToSubscriptions
    }

    val uiEventLiveData = MutableLiveData<MainViewCommand>()

    fun getSubscriptions(): List<Subscription> {
        return subscript
    }

    fun onSubscribeClicked() {
        uiEventLiveData.value = MainViewCommand.GoToSubscriptions
    }

    var showNoFeeds: Boolean = true
}