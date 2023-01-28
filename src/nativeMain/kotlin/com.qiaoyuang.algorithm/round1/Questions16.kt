package com.qiaoyuang.algorithm.round1

import kotlin.math.pow

fun test16() {
    fun printlnResult(base: Double, exponent: Int) = println("Result is ${base myPow exponent}, the correct result is ${base.pow(exponent)}")
    printlnResult(2.0, 1)
    printlnResult(2.0, 4)
    printlnResult(2.0, 5)
    printlnResult(2.0, 6)
    printlnResult(2.0, 0)
    printlnResult(2.0, -1)
    printlnResult(2.0, -4)
    printlnResult(2.0, -5)
    printlnResult(2.0, -6)
}

/**
 * Question16: Raise a number to an integer power(Don't need to consider big number problem)
 */
private infix fun Double.myPow(exponent: Int): Double {
    val result = recPow(exponent)
    return if (exponent < 0)
        1 / result
    else
        result
}

private fun Double.recPow(exponent: Int): Double =
    if (exponent == 0)
        1.0
    else {
        var result = recPow(exponent / 2)
        result *= if (exponent and 1 == 1) result * this else result
        result
    }
