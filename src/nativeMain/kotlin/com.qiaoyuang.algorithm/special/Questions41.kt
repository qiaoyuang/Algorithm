package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.Queue

/**
 * Questions 41: Implement a class MovingAverage, it could calculate the average of value
 */

fun test41() {
    printlnResult(intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), 3)
}

private class MovingAverage(private val size: Int) {

    private var sum = 0
    private val queue = Queue<Int>()

    fun next(value: Int): Double {
        if (queue.size == size)
            sum -= queue.dequeue()
        queue.enqueue(value)
        sum += value
        return sum.toDouble() / queue.size
    }
}

private fun printlnResult(nums: IntArray, size: Int) {
    println("Input the numbers ${nums.toList()} as a sequence, the size of slide window is $size, we can get averages:")
    val average = MovingAverage(size)
    nums.forEach {
        println(average.next(it))
    }
}