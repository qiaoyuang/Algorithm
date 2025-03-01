package com.qiaoyuang.algorithm.special

fun test39() {
    printlnResult(3, 2, 5, 4, 6, 1, 4, 2)
}

/**
 * Questions 39: Largest Rectangle in Histogram, LeetCode 84
 */
fun maxVolume(heights: IntArray): Int {
    val stack = ArrayDeque<Int>()
    var maxArea = 0
    heights.forEachIndexed { i, h ->
        while (stack.isNotEmpty() && h <= heights[stack.last()]) {
            val height = heights[stack.removeLast()]
            val width = if (stack.isEmpty()) i else i - stack.last() - 1
            val area = height * width
            if (area > maxArea)
                maxArea = area
        }
        stack.add(i)
    }
    while (stack.isNotEmpty()) {
        val height = heights[stack.removeLast()]
        val width = if (stack.isEmpty()) heights.size else heights.size - stack.last() - 1
        val area = height * width
        if (area > maxArea)
            maxArea = area
    }
    return maxArea
}

private fun printlnResult(vararg heights: Int) =
    println("The maximum volume of pool ${heights.toList()} is ${maxVolume(heights)}")