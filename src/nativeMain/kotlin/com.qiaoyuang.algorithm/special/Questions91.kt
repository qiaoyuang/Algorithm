package com.qiaoyuang.algorithm.special

import kotlin.math.min

fun test91() {
    printlnResult(arrayOf(
        intArrayOf(17, 2, 16),
        intArrayOf(15, 14, 5),
        intArrayOf(13, 3, 1),
    ))
}

/**
 * Questions 91: Paint House, LeetCode 256
 */
private fun minCost(costs: Array<IntArray>): Int {
    require(costs.isNotEmpty()) { "The costs can't be empty" }
    return min(
        costs red costs.lastIndex,
        costs green costs.lastIndex,
        costs blue costs.lastIndex,
    )
}

private infix fun Array<IntArray>.red(i: Int): Int =
    if (i == 0)
        first()[0]
    else
        min(green(i - 1), blue(i - 1)) + this[i][0]

private infix fun Array<IntArray>.green(i: Int): Int =
    if (i == 0)
        first()[1]
    else
        min(red(i - 1), blue(i - 1)) + this[i][1]

private infix fun Array<IntArray>.blue(i: Int): Int =
    if (i == 0)
        first()[2]
    else
        min(red(i - 1), green(i - 1)) + this[i][2]

private fun min(a: Int, b: Int, c: Int): Int =
    min(min(a, b), c)

private fun minCostInLoop(costs: Array<IntArray>): Int {
    require(costs.isNotEmpty()) { "The costs can't be empty" }
    val first = costs.first()
    val cache = intArrayOf(first[0], first[1], first[2])
    if (costs.size == 1)
        return cache.min()
    for (i in 1 ..< costs.size) {
        val red = min(cache[1], cache[2]) + costs[i][0]
        val green = min(cache[0], cache[2]) + costs[i][1]
        val blue = min(cache[0], cache[1]) + costs[i][2]
        cache[0] = red
        cache[1] = green
        cache[2] = blue
    }
    return cache.min()
}

private fun printlnResult(costs: Array<IntArray>) {
    val result = minCostInLoop(costs)
    println("The minimum cost is $result, is: ${result == minCost(costs)}")
}