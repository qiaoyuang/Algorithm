package com.qiaoyuang.algorithm.round1

fun test42() {
    intArrayOf(1, -2, 3, 10, -4, 7, 2, -5).printlnResult()
    intArrayOf().printlnResult()
    intArrayOf(1, 1, 1, 1, 1, 1, 1, 1).printlnResult()
    intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1).printlnResult()
}

/**
 * Questions42: Find the biggest sum of sub-array in a IntArray
 */
private fun IntArray.getBiggestSubArraySum(): Int {
    var biggest = 0
    var preSum = 0
    forEachIndexed { index, i ->
        preSum = if (index == 0 || preSum <= 0) i else preSum + i
        if (preSum > biggest)
            biggest = preSum
    }
    return biggest
}

private fun IntArray.printlnResult() =
    println("The biggest sum of sub-array in IntArray: ${toList()} is: ${getBiggestSubArraySum()}")
