package com.qiaoyuang.algorithm.round1

import kotlin.math.max

fun test47() {
    printlnResult(arrayOf(
        intArrayOf(1, 10, 3, 8),
        intArrayOf(12, 2, 9, 6),
        intArrayOf(5, 7, 4, 11),
        intArrayOf(3, 7, 16, 5),
    ))
    printlnResult(arrayOf(
        intArrayOf(1, 2, 3, 4, 5),
    ))
    printlnResult(arrayOf(
        intArrayOf(1),
        intArrayOf(2),
        intArrayOf(3),
        intArrayOf(4),
        intArrayOf(5),
    ))
    printlnResult(arrayOf(intArrayOf(99)))
}

/**
 * Questions 47: Give a matrix with m * n, different number(more than 0) in different lattice, you can start in left-top,
 * and you can move a lattice toward bottom or right, until to right-bottom,
 * find the best way to get the sum of numbers on the path
 */
private fun getBiggestNumber(matrix: Array<IntArray>): Int {
    require(matrix.isNotEmpty() && matrix.first().isNotEmpty()) { "The matrix can't be empty" }
    val first = matrix.first().first()
    return when {
        matrix.size == 1 && matrix.first().size == 1 -> matrix.first().first()
        matrix.size > 1 && matrix.first().size == 1 -> matrix.getBiggestNumber(1, 0, first)
        matrix.size == 1 && matrix.first().size > 1 -> matrix.getBiggestNumber(0, 1, first)
        else -> max(
            matrix.getBiggestNumber(0, 1, first),
            matrix.getBiggestNumber(1, 0, first),
        )
    }
}

/**
 * Recursion
 */
private fun Array<IntArray>.getBiggestNumber(i: Int, j: Int, sum: Int): Int {
    val firstSize = first().size
    val newSum = sum + this[i][j]
    val newI = i + 1
    val newJ = j + 1
    return when {
        newI < size && newJ < firstSize -> max(
            getBiggestNumber(i, newJ, newSum),
            getBiggestNumber(newI, j, newSum),
        )
        newI < size && newJ >= firstSize -> getBiggestNumber(newI, j, newSum)
        newI >= size && newJ < firstSize -> getBiggestNumber(i, newJ, newSum)
        else -> newSum
    }
}

/**
 * Loop
 */
private fun getBiggestNumberForLoop(matrix: Array<IntArray>): Int {
    val maxJ = matrix.first().size
    val maxValues = IntArray(maxJ)
    for (i in matrix.indices)
        for (j in matrix.first().indices) {
            val left = if (j > 0) maxValues[j - 1] else 0
            val up = if (i > 0) maxValues[j] else 0
            maxValues[j] = max(left, up) + matrix[i][j]
        }
    return maxValues.last()
}

private fun printlnResult(matrix: Array<IntArray>) =
    println("The biggest number on the path is: ${getBiggestNumber(matrix)}, ${getBiggestNumberForLoop(matrix)}")
