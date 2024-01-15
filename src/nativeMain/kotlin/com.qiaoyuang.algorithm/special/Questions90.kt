package com.qiaoyuang.algorithm.special

import kotlin.math.max

fun test90() {
    printlnResult(2, 3, 4, 5, 3)
}

/**
 * Questions 90: Similar with Questions 88, but the houses on a circle street
 */
private fun maxProperties(properties: IntArray): Int {
    require(properties.isNotEmpty()) { "The properties can't be empty" }
    if (properties.size == 1)
        return properties.first()
    return max(
        maxProperties(0, properties.size - 2, properties),
        maxProperties(1, properties.lastIndex, properties),
    )
}

private fun maxProperties(start: Int, end: Int, properties: IntArray): Int {
    val cache = intArrayOf(properties[start], max(properties[start], properties[start + 1]))
    for (i in start + 2 .. end) {
        val cacheCurrent = max(cache.first() + properties[i], cache.last())
        cache[0] = cache.last()
        cache[1] = cacheCurrent
    }
    return cache.last()
}

private fun printlnResult(vararg properties: Int) =
    println("The thief could stole the maximum property is ${maxProperties(properties)} in ${properties.toList()} on a circle street")