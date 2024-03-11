package com.qiaoyuang.algorithm.special

fun test105() {
    printlnResult(arrayOf(
        intArrayOf(1, 1, 0, 0, 1),
        intArrayOf(1, 0, 0, 1, 0),
        intArrayOf(1, 1, 0, 1, 0),
        intArrayOf(0, 0, 1, 0, 0),
    ))
}

/**
 * Question105: Use an two-dimensional array to represent an ocean.
 * Please find the maximum islands (the area that equals 1 and connected) area in it
 */
private fun findMaximumIsland(ocean: Array<IntArray>): Int {
    val rows = ocean.size
    val cols = ocean.first().size
    val visited = Array(rows) { BooleanArray(cols) }
    var maxArea = 0
    for (i in ocean.indices)
        for (j in ocean.first().indices)
            if (ocean[i][j] == 1 && !visited[i][j]) {
                val area = bfs(ocean, visited, i, j)
                if (area > maxArea)
                    maxArea = area
            }
    return maxArea
}

private val dirs = arrayOf(
    intArrayOf(-1, 0),
    intArrayOf(1, 0),
    intArrayOf(0, -1),
    intArrayOf(0, 1),
)

private fun bfs(ocean: Array<IntArray>, visited: Array<BooleanArray>, i: Int, j: Int): Int {
    val queue = ArrayDeque<IntArray>()
    queue.add(intArrayOf(i, j))
    visited[i][j] = true
    var area = 0
    while (queue.isNotEmpty()) {
        val (row, col) = queue.removeFirst()
        area++
        dirs.forEach { (dirR, dirC) ->
            val r = row + dirR
            val c = col + dirC
            if (r in ocean.indices && c in ocean.first().indices && ocean[r][c] == 1 && !visited[r][c]) {
                queue.add(intArrayOf(r, c))
                visited[r][c] = true
            }
        }
    }
    return area
}

private fun printlnResult(ocean: Array<IntArray>) =
    println("The maximum area is ${findMaximumIsland(ocean)}")