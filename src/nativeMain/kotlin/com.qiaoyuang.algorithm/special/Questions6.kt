package com.qiaoyuang.algorithm.special

fun test6() {
    printlnResult(intArrayOf(1, 2, 4, 6, 10), 8)
    printlnResult(intArrayOf(-10, -8, -5, -2, 2, 4, 6, 9, 12), 4)
}

/**
 * Find the indexes of two integers that sum is k, in an increasing IntArray.
 */
private infix fun IntArray.findTwoIndexes(k: Int): Pair<Int, Int> {
    require(isNotEmpty()) { "The IntArray can't be empty" }
    var pointer0 = 0
    var pointer1 = lastIndex
    while (pointer0 != pointer1) {
        val n0 = this[pointer0]
        val n1 = this[pointer1]
        when {
            n0 + n1 > k -> pointer1--
            n0 + n1 < k -> pointer0++
            else -> return pointer0 to pointer1
        }
    }
    throw IllegalArgumentException("This IntArray doesn't contain two integers that's sum is k")
}

private fun printlnResult(array: IntArray, k: Int) =
    println("The indexes of two integers is: ${array findTwoIndexes k} that sum is $k in an increasing IntArray: ${array.toList()}")