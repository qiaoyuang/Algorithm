package com.qiaoyuang.algorithm.special

import kotlin.math.min

fun test100() {
    printlnResult(
        intArrayOf(2),
        intArrayOf(3, 4),
        intArrayOf(6, 5, 7),
        intArrayOf(4, 1, 8 ,3)
    )
}

/**
 * Questions 100: Triangle, LeetCode 100
 */
private fun smallestPath(triangle: Array<out IntArray>): Int {
    require(triangle.isNotEmpty()) { "The triangle can't be empty" }
    val db = Array(triangle.size) { IntArray(triangle[it].size) }
    db[0][0] = triangle[0][0]
    for (i in 1 ..< triangle.size)
        for (j in 0 ..< triangle[i].size)
            db[i][j] = when (j) {
                0 -> db[i - 1][j]
                triangle[i].lastIndex -> db[i - 1][j - 1]
                else -> min(db[i - 1][j], db[i - 1][j - 1])
            } + triangle[i][j]
    return db.last().min()
}

private fun smallestPath2(triangle: Array<out IntArray>): Int {
    require(triangle.isNotEmpty()) { "The triangle can't be empty" }
    val db = IntArray(triangle.last().size)
    db[0] = triangle[0][0]
    for (i in 1 ..< triangle.size)
        for (j in triangle[i].lastIndex downTo 0)
            db[j] = when (j) {
                0 -> db[j]
                triangle[i].lastIndex -> db[j - 1]
                else -> min(db[j], db[j - 1])
            } + triangle[i][j]
    return db.min()
}

private fun printlnResult(vararg triangle: IntArray) =
    println("The smallest sum of path in the triangle is: ${smallestPath(triangle)}, ${smallestPath2(triangle)}")