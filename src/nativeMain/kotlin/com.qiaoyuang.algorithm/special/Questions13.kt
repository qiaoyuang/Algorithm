package com.qiaoyuang.algorithm.special

fun test13() {
    val matrix = NumsMatrix(
        arrayOf(
            intArrayOf(3, 0, 1, 4, 2),
            intArrayOf(5, 6, 3, 2, 1),
            intArrayOf(1, 2, 0, 1, 5),
            intArrayOf(4, 1, 0, 1 ,7),
            intArrayOf(1, 0, 3, 0, 5),
        )
    )
    printlnResult(matrix, 2, 1, 4, 3)
    printlnResult(matrix, 0, 0, 4, 4)
}

/**
 * Questions 13: Get the sum of a sum-matrix in a big matrix
 */
private class NumsMatrix(private val matrix: Array<IntArray>) {

    private val sums: Array<IntArray>

    init {
        require(matrix.isNotEmpty() && matrix.first().isNotEmpty()) { "The matrix can't be empty" }
        sums = Array(matrix.size + 1) {
            IntArray(matrix.first().size + 1)
        }
        repeat(matrix.size) { i ->
            var rowSum = 0
            repeat(matrix.first().size) { j ->
                rowSum += matrix[i][j]
                sums[i + 1][j + 1] = sums[i][j + 1] + rowSum
            }
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int =
        sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1]
}

private fun printlnResult(matrix: NumsMatrix, row1: Int, col1: Int, row2: Int, col2: Int) =
    println("The left-top coordinate is ($row1, $col1), the right-bottom coordinate is ($row2, $col2), the sum is ${matrix.sumRegion(row1, col1, row2, col2)}")