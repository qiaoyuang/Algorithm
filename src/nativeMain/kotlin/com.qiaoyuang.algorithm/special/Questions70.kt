package com.qiaoyuang.algorithm.special

fun test70() {
    println(intArrayOf(1, 2, 2, 3, 3).findNumberAppearOnce())
    println(intArrayOf(2, 2, 3, 3, 5).findNumberAppearOnce())
    println(intArrayOf(2, 2, 3, 5, 5).findNumberAppearOnce())
}

/**
 * Questions 70: Single Element in a sorted array, LeetCode 540
 */
private fun IntArray.findNumberAppearOnce(): Int {
    var start = 0
    var end = lastIndex
    while (start < end) {
        val midLeft = (end - start) / 2 + start
        val midRight = midLeft + 1
        if ((midLeft - start + 1) % 2 == 0) {
            if (this[midLeft] == this[midLeft - 1])
                start = midRight
            else
                end = midLeft - 1
        } else {
            if (this[midLeft] == this[midRight])
                start = midRight + 1
            else
                end = midLeft
        }
    }
    return this[start]
}