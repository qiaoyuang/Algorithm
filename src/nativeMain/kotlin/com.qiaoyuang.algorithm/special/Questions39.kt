package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.Stack

fun test39() {
    printlnResult(3, 2, 5, 4, 6, 1, 4, 2)
}

/**
 * Questions 39: The maximum volume in a pool
 */
fun IntArray.maxVolume(): Int {
    val stack = Stack<Int>()
    stack.push(-1)

    var maxArea = 0
    forEachIndexed { i, num ->
        while (stack.top() != -1 && this[stack.top()] >= num) {
            val height = this[stack.pop()]
            val width = i - stack.top() - 1
            val volume = height * width
            if (volume > maxArea)
                maxArea = volume
        }
        stack.push(i)
    }

    while (stack.top() != -1) {
        val height = this[stack.pop()]
        val width = size - stack.top() - 1
        val volume = height * width
        if (volume > maxArea)
            maxArea = volume
    }
    return maxArea
}

private fun printlnResult(vararg heights: Int) =
    println("The maximum volume of pool ${heights.toList()} is ${heights.maxVolume()}")