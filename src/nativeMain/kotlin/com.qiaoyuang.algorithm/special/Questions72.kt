package com.qiaoyuang.algorithm.special

fun test72() {
    printlnResult(100u)
    printlnResult(10000u)
    printlnResult(9u)
    printlnResult(4u)
    printlnResult(3u)
}

/**
 * Questions 72: Input an integer, find the arithmetic square root
 */
private fun arithmeticSquare(n: UInt): UInt {
    if (n == 0u || n == 1u)
        return n
    var start = 1u
    var end = n
    while (start < end) {
        val mid = (start + end) / 2u
        val square = mid * mid
        when {
            square > n -> end = mid - 1u
            square < n -> start = mid + 1u
            else -> return mid
        }
    }
    return start
}

private fun printlnResult(n: UInt) = println("The square root of $n is ${arithmeticSquare(n)}")
