package com.qiaoyuang.algorithm.special

import kotlin.math.min

fun test88() {
    println(minCost(1, 100, 1, 1, 100, 1))
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