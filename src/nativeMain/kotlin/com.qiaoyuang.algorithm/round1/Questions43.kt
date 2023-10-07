package com.qiaoyuang.algorithm.round1

import kotlin.math.pow

fun test43() {
    printlnResult(10)
    printlnResult(11)
    printlnResult(12)
    printlnResult(21345)
    printlnResult(101)
    printlnResult(111)
}

/**
 * Questions 43: Find the times of 1 appeared in 1...n
 */

private fun findCountOf1(n: Int): Int {
    require(n >= 1) { "The n must greater than 1" }
    val nStr = n.toString()
    var bit10 = 10f.pow(nStr.lastIndex).toInt()
    var result = 0
    nStr.forEachIndexed { index, c ->
        val digitC = c.digitToInt()
        val pre = if (index == 0) 0 else nStr.substring(0, index).toInt()

        result += when (digitC) {
            0 -> pre * bit10
            1 -> {
                if (index + 1 == nStr.length)
                    pre * bit10 + 1
                else
                    pre * bit10 + nStr.substring(index + 1, nStr.length).toInt() + 1
            }
            else -> (pre + 1) * bit10
        }

        bit10 /= 10
    }
    return result
}

private fun printlnResult(n: Int) =
    println("The times of 1 appeared in 1...$n is ${findCountOf1(n)}")