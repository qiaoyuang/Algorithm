package com.qiaoyuang.algorithm.special

fun test106() {
    printlnResult(arrayOf(
        intArrayOf(1, 3),
        intArrayOf(0, 2),
        intArrayOf(1, 3),
        intArrayOf(0, 2),
    ))
    printlnResult(arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(0, 2),
        intArrayOf(0, 1, 3),
        intArrayOf(0, 2),
    ))
}

/**
 * Questions 106: Judge if a graph is a binary-graph
 */
private fun isBinaryGraph(graph: Array<IntArray>): Boolean {
    val visited = IntArray(graph.size)
    graph.forEachIndexed { i, intArray ->
        if (visited[i] == 0)
            visited[i] = 1
        intArray.forEach { j ->
            if (visited[i] == 1) {
                if (visited[j] == 1)
                    return false
                visited[j] = 2
            } else {
                if (visited[j] == 2)
                    return false
                visited[j] = 1
            }
        }
    }
    return true
}

private fun isBinaryGraphBfs(graph: Array<IntArray>): Boolean {
    val visited = IntArray(graph.size)
    val queue = ArrayDeque<Int>()
    for (n in graph.indices) {
        if (visited[n] != 0)
            continue
        queue.add(n)
        while (queue.isNotEmpty()) {
            val i = queue.removeFirst()
            if (visited[i] == 0)
                visited[i] = 1
            graph[i].forEach { j ->
                if (visited[j] == 0) {
                    visited[j] = if (visited[i] == 1) 2 else 1
                    queue.add(j)
                } else if (visited[i] == visited[j])
                    return false
            }
        }
    }
    return true
}

private fun isBinaryGraphDfs(graph: Array<IntArray>): Boolean {
    val visited = IntArray(graph.size)
    for (n in graph.indices) {
        if (visited[n] != 0)
            continue
        if (!isBinaryGraphDfs(graph, visited, -1, n))
            return false
    }
    return true
}

private fun isBinaryGraphDfs(graph: Array<IntArray>, visited: IntArray, i: Int, j: Int): Boolean {
    if (i < 0)
        visited[j] = 1
    else if (visited[j] == 0)
        visited[j] = if (visited[i] == 1) 2 else 1
    else
        return visited[i] != visited[j]
    graph[j].forEach { k ->
        if (!isBinaryGraphDfs(graph, visited, j, k))
            return false
    }
    return true
}

private fun printlnResult(graph: Array<IntArray>) =
    println("Is the graph a binary-graph? (${isBinaryGraph(graph)}, ${isBinaryGraphBfs(graph)}, ${isBinaryGraphDfs(graph)})")