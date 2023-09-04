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
    fun printlnResult3(n: Int) = println("If $n is the integer power of 2: ${n.isPowerOf2()}")
    printlnResult3(1)
    printlnResult3(2)
    printlnResult3(16)
    printlnResult3(1024)
    printlnResult3(1025)
    fun printlnResult3(m: Int, n: Int) = println("We change ${getBitsToChange(m, n)} bits in binary that we can turn $m to $n")
    printlnResult3(0, 1)
    printlnResult3(2, 4)
    printlnResult3(10, 13)
    printlnResult3(1000, 1001)
    printlnResult3(9999, 9999.inv())
}

/**
 * Questions 15-1: Find the 1's count of the Integer n's binary bits.
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

/**
 * Questions 15-2: Use one line of code to determine whether a number is an integer power of 2.
 */
private fun Int.isPowerOf2(): Boolean {
    require(this > 0) { "The integer can't greater than 0" }
    return (this - 1) and this == 0
}

/**
 * Questions 15-3: Give the two integer m and n, Hom many bits in binary we change that we can turn m to n.
 */
private fun getBitsToChange(m: Int, n: Int) = numberOf1_2(m xor n)
