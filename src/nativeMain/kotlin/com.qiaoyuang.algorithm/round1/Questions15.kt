package com.qiaoyuang.algorithm.round1

fun test15() {
    fun printlnResult1(n: Int) = println("The 1's count of number ${n.toString(2)} is ${numberOf1(n)}")
    printlnResult1(0b1101)
    printlnResult1(0b0)
    printlnResult1(0b11101001110)
    printlnResult1(0b10110101)
    fun printlnResult2(n: Int) = println("The 1's count of number ${n.toString(2)} is ${numberOf1_2(n)}")
    printlnResult2(0b1101)
    printlnResult2(0b0)
    printlnResult2(0b11101001110)
    printlnResult2(0b10110101)
}

/**
 * Questions15: Find the 1's count of the Integer n's binary bits.
 */

private fun numberOf1(n: Int): Int {
    var _n = n
    var count = 0
    while (_n  > 0) {
        count++
        _n = (_n - 1) and _n
    }
    return count
}

private fun numberOf1_2(n: Int): Int {
    var i = 1
    var count = 0
    while (i > 0) {
        if (n and i > 0)
            count++
        i = i shl 1
    }
    return count
}