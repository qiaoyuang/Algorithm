package com.qiaoyuang.algorithm.special

fun test1() {
    printlnResult(15, 2)
    printlnResult(100, 4)
    printlnResult(101, 4)
    printlnResult(3, 4)
    printlnResult(96, 7)
}

/**
 * Questions 1: Implement a integer divide function, don't allow use '/', '*' and '%'
 */
private infix fun Int.divide(divisor: Int): Int {
    val dividend = this
    if (dividend == Int.MIN_VALUE && divisor == -1)
        return Int.MAX_VALUE
    var negative = 2
    val calculateDividend = if (dividend > 0) {
        negative--
        -dividend
    } else dividend
    val calculateDivisor = if (divisor > 0) {
        negative--
        -divisor
    } else divisor

    val result = divideCore(calculateDividend, calculateDivisor)
    return if (negative == 1) -result else result
}

private fun divideCore(dividend: Int, divisor: Int): Int {
    var result = 0
    var newDividend = dividend
    while (newDividend <= divisor) {
        var value = divisor
        var quotient = 1
        while (value >= 0xc0000000 && newDividend <= value + value) {
            quotient += quotient
            value += value
        }

        result +=  quotient
        newDividend -= value
    }
    return result
}

private fun printlnResult(dividend: Int, divisor: Int) =
    println("The $dividend divide the $divisor equals ${dividend divide divisor}")