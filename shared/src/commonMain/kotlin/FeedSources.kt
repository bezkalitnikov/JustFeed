package com.justfeed.common

class FeedSource(
    val id: String,
    val userName: String,
    val login: String,
    val password: String);

fun getFeedSources() : Array<FeedSource> {
    return arrayOf(FeedSource("vk", "Alex", "johh@foo.com", "abcd"))
}