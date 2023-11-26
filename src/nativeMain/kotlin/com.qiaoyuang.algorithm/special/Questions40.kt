package com.qiaoyuang.algorithm.special

fun test40() {
    printlnResult(arrayOf(
        booleanArrayOf(true, false, true, false, false),
        booleanArrayOf(false, false, true, true, true),
        booleanArrayOf(true, true, true, true, true),
        booleanArrayOf(true, false, false, true, false)
    ))
}

/**
 * Questions 40: Find the biggest rectangle only contains 1 in a rectangle contains 0 and 1
 */
private fun Array<BooleanArray>.biggestArea(): Int {
    require(isNotEmpty() && first().isNotEmpty()) { "The inputted rectangle can't be empty" }
    val heights = IntArray(first().size)
    var maxArea = 0
    forEach {
        for (i in it.indices)
            if (it[i])
                heights[i]++
            else
                heights[i] = 0
        val area = heights.maxVolume()
        if (area > maxArea)
            maxArea = area
    }
    return maxArea
}

private fun printlnResult(rectangle:  Array<BooleanArray>) =
    println("The maximum area is ${rectangle.biggestArea()}")
