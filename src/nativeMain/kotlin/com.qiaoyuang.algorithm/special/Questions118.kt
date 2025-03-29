package com.qiaoyuang.algorithm.special

fun test118() {
    printlnResult(
        intArrayOf(1, 2),
        intArrayOf(1, 3),
        intArrayOf(2, 4),
        intArrayOf(3, 4),
        intArrayOf(2, 5),
    )
}

/**
 * Questions 118: Redundant Connection, LeetCode 684
 */
private fun findExtraEdge(edges: Array<out IntArray>): IntArray {
    var maxVertex = 0
    edges.forEach { (u, v) ->
        maxVertex = maxOf(maxVertex, u, v)
    }
    val fathers = IntArray(maxVertex) { it }
    edges.forEach { array ->
        val (u, v) = array
        if (!union(fathers, u, v))
            return array
    }
    return intArrayOf()
}

private fun findFathers(fathers: IntArray, i: Int): Int {
    if (fathers[i] != i)
        fathers[i] = findFathers(fathers, fathers[i])
    return fathers[i]
}

private fun union(fathers: IntArray, i: Int, j: Int): Boolean {
    val fatherOfI = findFathers(fathers, i)
    val fatherOfJ = findFathers(fathers, j)
    if (fatherOfI == fatherOfJ)
        return false
    fathers[fatherOfJ] = fatherOfI
    return true
}

private fun printlnResult(vararg edges: IntArray) =
    println("The extra edge is ${findExtraEdge(edges).toList()}")