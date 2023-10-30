package com.qiaoyuang.algorithm.special

fun test3() {
    printlnResult(10)
}

/**
 * Given an integer n, found the counts of 1 in each 0...n, and output an IntArray
 */
private fun getCountsOf1(n: Int): IntArray {
    val result = IntArray(n + 1)
    for (i in 1..n)
        result[i] = result[i shr 1] + (i and 1)
    return result
}

private fun printlnResult(n: Int) =
    println("Given the number $n, the counts of 1 in 0...n is ${getCountsOf1(n).toList()}")