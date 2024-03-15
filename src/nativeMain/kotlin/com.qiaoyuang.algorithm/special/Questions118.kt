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
 * Questions 118: Find the extra edge in a graph, if we remove this edge，we can transfer this graph to a tree,
 * if there are multiple edges in condition, find the edge that lastly appeared in the array
 */
private fun findExtraEdge(edges: Array<out IntArray>): IntArray {
    val fathers = IntArray(edges.size + 1) { it }
    edges.forEach { array ->
        val (i, j) = array
        if (!union(fathers, i, j))
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
    val result = fatherOfI != fatherOfJ
    if (result)
        fathers[fatherOfI] = fatherOfJ
    return result
}

private fun printlnResult(vararg edges: IntArray) =
    println("The extra edge is ${findExtraEdge(edges).toList()}")