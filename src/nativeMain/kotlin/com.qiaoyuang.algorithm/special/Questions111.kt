package com.qiaoyuang.algorithm.special

fun test111() {
    printlnResult(
        arrayOf(arrayOf("a", "b"), arrayOf("b", "c")),
        doubleArrayOf(2.0, 3.0),
        arrayOf(arrayOf("a", "c"), arrayOf("b", "a"), arrayOf("a", "e"), arrayOf("a", "a"), arrayOf("x", "x"))
    )
}

/**
 * Questions 111: Evaluate Division, LeetCode 399
 */
private fun calculateDivisions(equations: Array<Array<String>>, values: DoubleArray, queries: Array<Array<String>>): DoubleArray {
    val graph = HashMap<String, HashMap<String, Double>>()
    val visited = HashSet<String>()
    for (i in equations.indices) {
        val (a, b) = equations[i]
        if (!graph.containsKey(a))
            graph[a] = HashMap()
        graph[a]!![b] = values[i]
        graph[a]!![a] = 1.0
        if (!graph.containsKey(b))
            graph[b] = HashMap()
        graph[b]!![a] = 1 / values[i]
    }
    val result = DoubleArray(queries.size)
    queries.forEachIndexed { i, (a, b) ->
        result[i] = dfs(graph, visited, a, b, 1.0)
        visited.clear()
    }
    return result
}

private fun dfs(
    graph: HashMap<String, HashMap<String, Double>>,
    visited: HashSet<String>,
    a: String, b: String, result: Double): Double {
    graph[a]?.forEach { (c, r) ->
        if (b == c)
            return result * r
        visited.add(a)
        if (!visited.contains(c)) {
            val rel = dfs(graph, visited, c, b, result * r)
            if (rel != -1.0)
                return rel
        }
    }
    return -1.0
}

private fun printlnResult(equations: Array<Array<String>>, values: DoubleArray, queries: Array<Array<String>>) =
    println("The results are ${calculateDivisions(equations, values, queries).toList()}")