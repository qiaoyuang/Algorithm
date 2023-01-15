package com.qiaoyuang.algorithm.round1

import kotlin.math.pow

fun test14() {
    fun printlnResult1(n: Int) = println("The rope length is $n, the max product is ${getTheMaxCutProduct1(n)}")
    printlnResult1(2)
    printlnResult1(3)
    printlnResult1(5)
    printlnResult1(8)
    printlnResult1(12)
    fun printlnResult2(n: Int) = println("The rope length is $n, the max product is ${getTheMaxCutProduct2(n)}")
    printlnResult2(2)
    printlnResult2(3)
    printlnResult2(5)
    printlnResult2(8)
    printlnResult2(12)
}

/**
 * Questions14: We have a rope that length is n, cut the rope into m pieces (m > 0, n > 0).
 * Every pieces named such as: k[0], k[1]...k[m], please find the biggest value of the k[0] * k[1] *... * k[m].
 */

// Dynamic programming
private fun getTheMaxCutProduct1(n: Int): Int = when {
    n < 2 -> throw IllegalArgumentException("The n must bigger than 1")
    n == 2 -> 1
    n == 3 -> 2
    else -> {
        val products = IntArray(n + 1) { it }
        var max: Int
        for (i in 4..n) {
            max = 0
            for (j in 1..i) {
                val product = products[j] * products[i - j]
                if (max < product)
                    max = product
                products[i] = max
            }
        }
        max = products[n]
        max
    }
}

// Greedy algorithm
private fun getTheMaxCutProduct2(n: Int): Int = when {
    n < 2 -> throw IllegalArgumentException("The n must bigger than 1")
    n == 2 -> 1
    n == 3 -> 2
    else -> {
        var timesOf3 = n / 3
        if (n - timesOf3 * 3 == 1)
            timesOf3--
        val timesOf2 = (n - timesOf3 * 3) shr 1
        ((3.0.pow(timesOf3)) * (2.0.pow(timesOf2))).toInt()
    }
}