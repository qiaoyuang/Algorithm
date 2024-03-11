package com.qiaoyuang.algorithm.special

fun test107() {
    printlnResult(arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(1, 1, 1),
    ))
}

/**
 * Questions 107: Input a matrix that at least contain a 0,
 * output a matrix that each cell equals the distance that from the closest 0
 */
private fun distancesFrom0(matrix: Array<IntArray>): Array<IntArray> {
    val result = Array(matrix.size) { IntArray(matrix[it].size) { -1 } }
    val dirs = arrayOf(
        intArrayOf(-1, 0),
        intArrayOf(1, 0),
        intArrayOf(0, -1),
        intArrayOf(0, 1),
    )
    matrix.forEachIndexed { i, intArray ->
        intArray.forEachIndexed label@{ j, num ->
            if (result[i][j] != -1)
                return@label
            if (num == 0) {
                result[i][j] = 0
                dfs(matrix, result, dirs, i, j, 0)
            }
        }
    }
    return result
}

private fun dfs(matrix: Array<IntArray>, result: Array<IntArray>, dirs: Array<IntArray>, i: Int, j: Int, distance: Int) {
    dirs.forEach { (r, c) ->
        val row = r + i
        val col = c + j
        if (row in matrix.indices && col in matrix[i].indices && matrix[row][col] != 0) {
            val d = distance + 1
            if (result[row][col] == -1 || d < result[row][col]) {
                result[row][col] = d
                dfs(matrix, result, dirs, row, col, d)
            }
        }
    }
}

private fun printlnResult(matrix: Array<IntArray>) {
    println("The matrix is:")
    matrix.forEach {
        it.forEach { num ->
            print("$num ")
        }
        println()
    }
    println("The closest distances from 0 are: ")
    distancesFrom0(matrix).forEach {
        it.forEach { num ->
            print("$num ")
        }
        println()
    }
}