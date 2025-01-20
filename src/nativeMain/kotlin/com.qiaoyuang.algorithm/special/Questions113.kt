package com.qiaoyuang.algorithm.special

import androidx.collection.MutableIntList
import androidx.collection.mutableIntListOf
import androidx.collection.mutableIntObjectMapOf

fun test113() {
    printlnResult(4, arrayOf(
        intArrayOf(1, 0), intArrayOf(2, 0), intArrayOf(3, 1), intArrayOf(3, 2)
    ))
}

/**
 * Questions 113: Course Schedule II, LeetCode 113
 */
private fun findOrder(num: Int, prerequisites: Array<IntArray>): IntArray {
    val inDegrees = IntArray(num)
    val graph = mutableIntObjectMapOf<MutableIntList>()
    prerequisites.forEach { (latter, pre) ->
        graph[pre]?.add(latter) ?: run { graph[pre] = mutableIntListOf(latter) }
        inDegrees[latter]++
    }
    val queue = ArrayDeque<Int>()
    inDegrees.forEachIndexed { i, inDegree ->
        if (inDegree == 0)
            queue.add(i)
    }
    val order = ArrayList<Int>()
    while (queue.isNotEmpty()) {
        val course = queue.removeFirst()
        order.add(course)
        graph[course]?.run {
            forEach {
                if (--inDegrees[it] == 0)
                    queue.add(it)
            }
            graph.remove(course)
        }

    }
    return if (graph.isEmpty()) order.toIntArray() else intArrayOf()
}

private fun printlnResult(num: Int, prerequisites: Array<IntArray>) =
    println("The The courses sequence is ${findOrder(num, prerequisites).toList()}")