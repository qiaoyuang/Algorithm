package com.qiaoyuang.algorithm.special

fun test39() {
    printlnResult(3, 2, 5, 4, 6, 1, 4, 2)
}

/**
 * Questions 39: The maximum volume in a pool
 */
fun maxVolume(heights: IntArray): Int {
    val stack = ArrayDeque<Int>()
    var maxArea = 0
    heights.forEachIndexed { i, h ->
        while (stack.isNotEmpty() && h <= heights[stack.last()]) {
            val index = stack.removeLast()
            val height = heights[index]
            val width = if (stack.isEmpty()) i - 1 else i - stack.last() - 1
            val area = height * width
            if (area > maxArea)
                maxArea = area
        }
        stack.add(i)
    }
    while (stack.isNotEmpty()) {
        val index = stack.removeLast()
        val height = heights[index]
        val width = if (stack.isEmpty()) heights.size - 1 else heights.size - stack.last() - 1
        val area = height * width
        if (area > maxArea)
            maxArea = area
    }
    return maxArea
}

private fun printlnResult(vararg heights: Int) =
    println("The maximum volume of pool ${heights.toList()} is ${maxVolume(heights)}")