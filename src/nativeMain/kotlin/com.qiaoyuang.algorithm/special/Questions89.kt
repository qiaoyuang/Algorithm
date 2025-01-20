package com.qiaoyuang.algorithm.special

import kotlin.math.max

fun test89() {
    printlnResult(2, 3, 4, 5, 3)
}

/**
 * Questions 89: House Robber, LeetCode 198
 */
private fun maxProperties(vararg properties: Int): Int {
    require(properties.isNotEmpty()) { "The properties can't be empty" }
    val first = properties.first()
    if (properties.size == 1)
        return first
    val cache = intArrayOf(first, max(first, properties[1]))
    for (i in 2 ..< properties.size) {
        val cacheCurrent = max(cache.first() + properties[i], cache.last())
        cache[0] = cache.last()
        cache[1] = cacheCurrent
    }
    return cache.last()
}

private fun printlnResult(vararg properties: Int) =
    println("The thief could stole the maximum property is ${maxProperties(*properties)} in ${properties.toList()}")