package com.justfeed.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.justfeed.common.FeedSource
import com.justfeed.common.Feed

class MainViewModel : ViewModel() {
    private val _feedSources: Array<FeedSource> by lazy {
        com.justfeed.common.getFeedSources()
    }

    fun getFeedSources(): Array<FeedSource> {
        return _feedSources
    }

    private val _feeds: Array<Feed> by lazy {
        com.justfeed.common.getFeeds()
    }

    fun getFeeds(): Array<Feed> {
        return _feeds
    }

    enum class MainViewCommand {
        GoToSubscriptions
    }

    val uiEventLiveData = MutableLiveData<MainViewCommand>()

    fun onSubscribeClicked() {
        uiEventLiveData.value = MainViewCommand.GoToSubscriptions
    }

    var showNoFeeds: Boolean = true
}