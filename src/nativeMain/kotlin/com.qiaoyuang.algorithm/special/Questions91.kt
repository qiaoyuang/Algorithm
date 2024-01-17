package com.qiaoyuang.algorithm.special

import kotlin.math.min

fun test91() {
    println(
        minCost(
            arrayOf(
                intArrayOf(17, 2, 16),
                intArrayOf(15, 14, 5),
                intArrayOf(13, 3, 1),
            )
        )
    )
}

/**
 * Questions 91: Paint houses to red, green or blue. The houses that nearby can't be painted with same color.
 * Given a series IntArrays to represent the cost of painting, find the minimum cost.
 */
private fun minCost(costs: Array<IntArray>): Int =
    min(
        costs red costs.lastIndex,
        costs green costs.lastIndex,
        costs blue costs.lastIndex,
        )

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