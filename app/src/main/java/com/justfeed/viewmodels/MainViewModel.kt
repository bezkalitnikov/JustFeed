package com.justfeed.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.justfeed.common.subscriptions.Subscription

class MainViewModel : ViewModel() {
    private val _subscriptions: List<Subscription> by lazy {
        com.justfeed.common.subscriptions.getSubscriptions();
    }

    enum class MainViewCommand {
        GoToSubscriptions
    }

    val uiEventLiveData = MutableLiveData<MainViewCommand>()

    fun getSubscriptions(): List<Subscription> {
        return _subscriptions
    }

    fun onSubscribeClicked() {
        uiEventLiveData.value = MainViewCommand.GoToSubscriptions
    }
}