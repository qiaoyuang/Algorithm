package com.qiaoyuang.algorithm.special

fun test116() {
    printlnResult(arrayOf(
        intArrayOf(1, 1, 0),
        intArrayOf(1, 1, 0),
        intArrayOf(0, 0, 1),
    ))
}

/**
 * Questions 116: Find the count of circles of friends in a class
 */
private fun findCountByBFS(matrix: Array<IntArray>): Int {
    require(matrix.isNotEmpty()) { "The matrix can't be empty" }
    val dirs = arrayOf(
        intArrayOf(-1, 0),
        intArrayOf(1, 0),
        intArrayOf(0, -1),
        intArrayOf(0, 1),
    )
    val visited = Array(matrix.size) { BooleanArray(matrix[it].size) }
    var count = 0
    matrix.forEachIndexed { i, array ->
        array.forEachIndexed { j, isFriend ->
            if (!visited[i][j] && isFriend == 1) {
                bfs(matrix, visited, dirs, i, j)
                count++
            }
        }
    }
    return count
}

private fun bfs(matrix: Array<IntArray>, visited: Array<BooleanArray>, dirs: Array<IntArray>, i: Int, j: Int) {
    dirs.forEach {
        val r = i + it.first()
        val c = j + it.last()
        if (r in matrix.indices && c in matrix.first().indices && !visited[r][c] && matrix[r][c] == 1) {
            visited[r][c] = true
            bfs(matrix, visited, dirs, r, c)
        }
    }
}

private fun findCountByDisjointSets(matrix: Array<IntArray>): Int {
    val fathers = IntArray(matrix.size) { it }
    var count = matrix.size
    repeat(matrix.size) { i ->
        for (j in i + 1 ..< matrix.size)
            if (matrix[i][j] == 1 && union(fathers, i, j))
                count--
    }
    return count
}

private fun findFathers(fathers: IntArray, i: Int): Int {
    if (fathers[i] != i)
        fathers[i] = findFathers(fathers, fathers[i])
    return fathers[i]
}

private fun union(fathers: IntArray, i: Int, j: Int): Boolean {
    val fatherOfI = findFathers(fathers, i)
    val fatherOfJ = findFathers(fathers, j)
    val result = fatherOfI != fatherOfJ
    if (result)
        fathers[fatherOfI] = fatherOfJ
    return result
}

private fun printlnResult(matrix: Array<IntArray>) =
    println("The count of circles of friends is (${findCountByBFS(matrix)}, ${findCountByDisjointSets(matrix)})")