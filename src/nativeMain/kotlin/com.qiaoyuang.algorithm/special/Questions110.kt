package com.qiaoyuang.algorithm.special

fun test110() {
    printlnResult(arrayOf(
        intArrayOf(1, 2),
        intArrayOf(3),
        intArrayOf(3),
        intArrayOf(),
    ))
    printlnResult(arrayOf(
        intArrayOf(1, 4),
        intArrayOf(2),
        intArrayOf(3, 5),
        intArrayOf(5),
        intArrayOf(5),
        intArrayOf()
    ))
}

/**
 * Questions 110: Find the all paths of node 0 to node n - 1 in a
 */
private fun findPaths(graph: Array<IntArray>): List<List<Int>> {
    val stack = ArrayDeque<Int>()
    val result = ArrayList<List<Int>>()
    val list = ArrayList<Int>()
    stack.add(0)
    val stackOfCount = ArrayDeque<Int>()
    while (stack.isNotEmpty()) {
        val node = stack.removeLast()
        list.add(node)
        if (stackOfCount.isNotEmpty())
            stackOfCount.add(stackOfCount.removeLast() - 1)
        if (node == graph.lastIndex) {
            result.add(list.toList())
            list.removeLast()
        } else {
            stackOfCount.add(graph[node].size)
            graph[node].forEach {
                stack.add(it)
            }
        }
        while (stackOfCount.isNotEmpty() && stackOfCount.last() == 0) {
            stackOfCount.removeLast()
            list.removeLast()
        }
    }
    return result
}

private fun printlnResult(graph: Array<IntArray>) {
    println("The all paths are:")
    findPaths(graph).forEach {
        println(it)
    }
}