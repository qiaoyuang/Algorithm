package com.qiaoyuang.algorithm.special

import kotlin.math.min

fun test88() {
    printlnResult(1, 100, 1, 1, 100, 1)
}

/**
 * Questions 88: Minimum cost for climbing stairs
 */
private fun minCost(vararg costs: Int): Int {
    require(costs.size >= 2) { "The size of costs must greater or equal than 2" }
    return minCost(costs, costs.lastIndex)
}

private fun minCost(costs: IntArray, index: Int): Int = when {
    index < 2 -> costs[index]
    else -> min(minCost(costs, index - 1), minCost(costs, index - 2)) + costs[index]
}

private fun minCostInLoop(vararg costs: Int): Int {
    if (costs.size == 2)
        return costs.last()
    require(costs.size > 2) { "The size of costs must greater or equal than 2" }
    val cache = intArrayOf(costs[0], costs[1])
    for (i in 2 ..< costs.size) {
        val currentCost = min(cache.first(), cache.last()) + costs[i]
        cache[0] = cache.last()
        cache[1] = currentCost
    }
    return cache.last()
}

private fun printlnResult(vararg costs: Int) {
    val result = minCostInLoop(*costs)
    println("The minimum cost in ${costs.toList()} is ${result}, is ${result == minCost(*costs)}")
}