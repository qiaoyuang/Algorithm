package com.qiaoyuang.algorithm.round1

import com.qiaoyuang.algorithm.round0.PriorityQueue
import com.qiaoyuang.algorithm.round0.partition

fun test40() {
    printResult(intArrayOf(5, 4, 1, 6, 2, 7, 3, 8), 4)
}

/**
 * Questions40: Find the smallest k numbers in an IntArray
 */

private infix fun IntArray.findSmallestKNumbers1(k: Int): PriorityQueue<Int> {
    require(isNotEmpty() && k in 1 ..< size) { "The k must be less than size of the IntArray and greater than 0" }
    val queue = PriorityQueue<Int>()
    queue.enqueue(first())
    for (i in 1 ..< size) {
        if (this[i] > queue.peak)
            continue
        queue.enqueue(this[i])
        if (queue.size > 4)
            queue.dequeue()
    }
    return queue
}

private infix fun IntArray.findSmallestKNumbers2(k: Int): IntArray {
    require(isNotEmpty() && k in 1 ..< size) { "The k must less than size of the IntArray and greater than 0" }
    var start = 0
    var end = lastIndex
    var index = partition(start, end)
    while (index != k - 1) {
        if (index > k - 1)
            end = index - 1
        else
            start = index + 1
        index = partition(start, end)
    }
    return IntArray(k) { this[it] }
}

private fun printResult(array: IntArray, k: Int) {
    println("The smallest k numbers in IntArray: ${array.toList()} is/are: ${array findSmallestKNumbers1 k}")
    println("The smallest k numbers in IntArray: ${array.toList()} is/are: ${(array findSmallestKNumbers2 k).toList()}")
}