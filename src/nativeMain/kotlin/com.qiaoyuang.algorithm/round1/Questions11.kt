package com.qiaoyuang.algorithm.round1

import kotlin.math.min

fun test11() {
    fun IntArray.printlnResult() = println("Find the IntArray ${toString()}'s smallest number is ${findMinNumber()}")
    intArrayOf(1, 2, 3, 4, 5, 6).printlnResult()
    intArrayOf(4, 5, 6, 1, 2, 3).printlnResult()
    intArrayOf(3, 4, 5, 6, 1, 2).printlnResult()
    intArrayOf(5, 6, 1, 2, 3, 4).printlnResult()
    intArrayOf(8).printlnResult()
    intArrayOf(8, 6).printlnResult()
    intArrayOf(1, 0, 1, 1, 1).printlnResult()
    intArrayOf(1, 1, 1, 0, 1).printlnResult()
    intArrayOf(1, 1, 0, 1, 1).printlnResult()
}

/**
 * Questions11: We have a whirling IntArray. For example, the [3, 4, 5, 1, 2] is sorted IntArray [1, 2, 3, 4, 5]'s whirling,
 * find the smallest number in whirling IntArray.
 */

private fun IntArray.findMinNumber(): Int {
    if (isEmpty()) throw IllegalArgumentException("The IntArray is empty")
    return findMinNumber(0, lastIndex)
}

private tailrec fun IntArray.findMinNumber(start: Int, end: Int): Int {
    if (start == end)
        return this[start]
    val mid = (start + end) shr 1
    val first = this[start]
    val middle = this[mid]
    val middle1 = this[mid + 1]
    val last = this[end]
    return when {
        first == middle && middle1 == last -> this.min()
        first <= middle && middle1 <= last -> min(first, middle1)
        first > middle && middle1 <= last -> findMinNumber(start, mid)
        first <= middle && middle1 > last -> findMinNumber(mid + 1, end)
        else -> throw IllegalArgumentException("The IntArray receiver is not a whirling IntArray")
    }
}