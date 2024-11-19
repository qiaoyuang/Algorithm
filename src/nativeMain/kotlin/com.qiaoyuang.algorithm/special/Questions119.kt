package com.qiaoyuang.algorithm.special

import kotlin.math.max

fun test119() {
    printlnResult(10, 5, 9, 2, 4, 3)
}

/**
 * Questions 119: Input an IntArray, find the length of longest sub-sequence
 */
private fun longestSubLengthByDisjointSets(array: IntArray): Int {
    require(array.isNotEmpty()) { "The array can't be empty" }
    if (array.size == 1)
        return 1
    val fathers = HashMap<Int, Int>(array.size)
    val count = HashMap<Int, Int>(array.size)
    array.forEach {
        fathers[it] = it
        count[it] = 1
    }

    array.forEach { 
        if (fathers.contains(it - 1))
            union(fathers, count, it, it - 1)
        if (fathers.contains(it + 1))
            union(fathers, count, it, it + 1)
    }

    return count.values.max()
}

private fun findFathers(fathers: HashMap<Int, Int>, i: Int): Int {
    if (fathers[i] != i)
        fathers[i] = findFathers(fathers, fathers[i]!!)
    return fathers[i]!!
}

private fun union(fathers: HashMap<Int, Int>, counts: HashMap<Int, Int>, i: Int, j: Int): Boolean {
    val fatherOfI = findFathers(fathers, i)
    val fatherOfJ = findFathers(fathers, j)
    val result = fatherOfI != fatherOfJ
    if (result) {
        fathers[fatherOfI] = fatherOfJ
        counts[fatherOfJ] = counts[fatherOfI]!! + counts[fatherOfJ]!!
    }
    return result
}

private fun longestSubLengthByDFS(array: IntArray): Int {
    val graph = HashMap<Int, Int>(array.size)
    array.forEach {
        graph[it] = 0
    }

    array.forEach {
        if (graph.contains(it + 1))
            graph[it] = it + 1
    }
    var result = 0
    graph.keys.forEach { num ->
        var length = 1
        var number = graph[num]!!
        while (number > 0) {
            number = graph[number]!!
            length++
        }
        if (length > result)
            result = length
    }
    return result
}

private fun topologicalSort(array: IntArray): Int {
    val set = array.toHashSet()
    val queue = ArrayDeque<Int>()
    array.forEach {
        if (!set.contains(it - 1))
            queue.add(it)
    }
    var max = 0
    queue.forEach {
        var node = it
        while (set.contains(node + 1))
            node++
        max = max(max, node - it + 1)
    }
    return max
}

private fun printlnResult(vararg array: Int) =
    println("The longest length of consequent sub-sequence in ${array.toList()} is (${longestSubLengthByDisjointSets(array)}, ${longestSubLengthByDFS(array)}, ${topologicalSort(array)})")