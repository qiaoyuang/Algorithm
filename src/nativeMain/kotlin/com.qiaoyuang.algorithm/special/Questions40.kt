package com.qiaoyuang.algorithm.special

fun test40() {
    printlnResult(arrayOf(
        charArrayOf('1', '0', '1', '0', '0'),
        charArrayOf('0', '0', '1', '1', '1'),
        charArrayOf('1', '1', '1', '1', '1'),
        charArrayOf('1', '0', '0', '1', '0'),
    ))
}

/**
 * Questions 40: Find the biggest rectangle only contains 1 in a rectangle contains 0 and 1
 */
private fun biggestArea(rectangle: Array<CharArray>): Int {
    val heights = IntArray(rectangle.first().size)
    var maxArea = 0
    rectangle.forEach {
        it.forEachIndexed { i, c ->
            when (c) {
                '0' -> heights[i] = 0
                '1' -> heights[i]++
            }
        }
        val area = maxVolume(heights)
        if (area > maxArea)
            maxArea = area
    }
    return maxArea
}

private fun printlnResult(rectangle: Array<CharArray>) =
    println("The maximum area is ${biggestArea(rectangle)}")
