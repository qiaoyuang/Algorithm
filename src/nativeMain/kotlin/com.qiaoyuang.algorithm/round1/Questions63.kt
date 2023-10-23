package com.qiaoyuang.algorithm.round1

import kotlin.math.max
import kotlin.math.min

fun test63() {
    printlnResult(intArrayOf(9, 11, 8, 5, 7, 12, 16, 14))
}

/**
 * Questions 63: Find the bought price and sold price that a stock could make the highest benefit
 */
private fun IntArray.findHighestBenefit(): Int {
    var max = 0
    var minI = 0

    for (i in 0 ..< lastIndex) {
        minI = if (i == 0) this[i] else min(minI, this[i])
        max = max(max, this[i + 1] - minI)
    }
    return max
}

private fun printlnResult(stockPrices: IntArray) =
    println("The stock prices in period of time are ${stockPrices.toList()}, the highest benefit is ${stockPrices.findHighestBenefit()}")