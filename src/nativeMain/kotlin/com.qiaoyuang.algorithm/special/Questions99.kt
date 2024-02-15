package com.qiaoyuang.algorithm.special

import kotlin.math.min

fun test99() {
    printlnResult(
        intArrayOf(1, 3, 1),
        intArrayOf(2, 5, 2),
        intArrayOf(3, 4, 1),
    )
}

/**
 * Questions 99: The shortest path in a rectangle
 */
private fun shortestPath(rectangle: Array<out IntArray>): Int {
    require(rectangle.isNotEmpty()) { "The rectangle can't be empty" }
    val m = rectangle.size
    val n = rectangle.first().size
    val db = IntArray(n)
    for (i in 0 ..< m)
        for (j in 0 ..< n)
            db[j] = rectangle[i][j] + when {
                j - 1 < 0 -> db[j]
                db[j] == 0 -> db[j - 1]
                else -> min(db[j], db[j - 1])
            }
    return db.last()
}

private fun printlnResult(vararg rectangle: IntArray) =
    println("The shortest path is ${shortestPath(rectangle)}")