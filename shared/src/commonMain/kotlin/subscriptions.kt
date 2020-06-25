package com.justfeed.common.subscriptions

class Subscription(
    val id: String,
    val userName: String,
    val login: String,
    val password: String);

fun getSubscriptions() : List<Subscription> {
    //return listOf<Subscription>(Subscription("vk", "Alex", "johh@foo.com", "abcd"))
    return listOf<Subscription>()
}