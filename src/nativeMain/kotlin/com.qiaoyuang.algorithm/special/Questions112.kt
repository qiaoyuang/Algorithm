package com.qiaoyuang.algorithm.special

fun test112() {
    printlnResult(arrayOf(
        intArrayOf(3, 4, 5),
        intArrayOf(3, 2, 8),
        intArrayOf(2, 2, 1),
    ))
}

/**
 * Questions 112: Find the length of longest increasing path in a matrix
 */
private fun longestIncreasingPath(matrix: Array<IntArray>): Int {
    if (matrix.isEmpty() || matrix.first().isEmpty())
        return 0
    val dirs = arrayOf(intArrayOf(0 ,1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
    var result = 0
    for (i in matrix.indices)
        for (j in matrix[i].indices) {
            val length = dfs(matrix, dirs, 1, i, j)
            if (length > result)
                result = length
        }
    return result
}

private fun dfs(matrix: Array<IntArray>, dirs: Array<IntArray>, length: Int, i: Int, j: Int): Int {
    var result = length
    dirs.forEach { (r, c) ->
        val row = r + i
        val col = c + j
        if (row in matrix.indices && col in matrix[i].indices && matrix[row][col] > matrix[i][j]) {
            val newLength = dfs(matrix, dirs, length + 1, row, col)
            if (newLength > result)
                result = newLength
        }
    }
    return result
}

private fun printlnResult(matrix: Array<IntArray>) =
    println("The length of longest increasing path is ${longestIncreasingPath(matrix)}")