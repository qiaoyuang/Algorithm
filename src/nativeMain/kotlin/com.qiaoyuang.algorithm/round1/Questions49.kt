package com.qiaoyuang.algorithm.round1

import kotlin.math.min

fun test49() {
    printlnResult(1)
    printlnResult(2)
    printlnResult(3)
    printlnResult(4)
    printlnResult(5)
    printlnResult(6)
    printlnResult(7)
    printlnResult(8)
    printlnResult(9)
    printlnResult(10)
    printlnResult(1500)
}

/**
 * Questions 49: Find the nth ugly number(only own factors: 2, 3, 5)
 */
private fun uglyNumber(n: Int): Int {
    require(n > 0) { "The n must greater than 0" }
    return if (n == 1)
        1
    else {
        val cache = IntArray(n)
        cache[0] = 1
        var nextIndex = 1
        var multiply2 = 0
        var multiply3 = 0
        var multiply5 = 0
        while (nextIndex < n) {
            val min = min(cache[multiply2] * 2, cache[multiply3] * 3, cache[multiply5] * 5)
            cache[nextIndex] = min
            while (cache[multiply2] * 2 <= cache[nextIndex])
                multiply2++
            while (cache[multiply3] * 3 <= cache[nextIndex])
                multiply3++
            while (cache[multiply5] * 5 <= cache[nextIndex])
                multiply5++
            nextIndex++
        }
        cache.last()
    }
}

private fun min(a: Int, b: Int, c: Int): Int = min(min(a, b), c)

private fun printlnResult(n: Int) = println("The number $n ugly number is: ${uglyNumber(n)}")
