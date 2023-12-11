package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.PriorityQueue

fun test59() {
    val initials = intArrayOf(4, 5, 8, 2)
    val kthLargest = KthLargest(initials, 3)
    printlnResult(kthLargest)
    kthLargest.add(3)
    printlnResult(kthLargest)
    kthLargest.add(5)
    printlnResult(kthLargest)
}

/**
 * Questions 59: Find the kth number in a number stream.
 */
private class KthLargest(nums: IntArray, val k: Int) {

    private val priorityQueue = PriorityQueue<Int> { a, b -> b - a }

    init {
        nums.forEach {
            add(it)
        }
    }

    fun add(num: Int) {
        if (priorityQueue.size < k)
            priorityQueue.enqueue(num)
        else if (num > priorityQueue.peak) {
            priorityQueue.dequeue()
            priorityQueue.enqueue(num)
        }
    }

    fun kth(): Int = priorityQueue.peak
}

private fun printlnResult(kthLargest: KthLargest) =
    println("The ${kthLargest.k}th number is: ${kthLargest.kth()}")
