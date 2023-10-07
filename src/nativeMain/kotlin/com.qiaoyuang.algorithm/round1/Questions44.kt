package com.qiaoyuang.algorithm.round1

import kotlin.math.pow

fun test44() {
    printlnResult(0)
    printlnResult(1)
    printlnResult(5)
    printlnResult(10)
    printlnResult(13)
    printlnResult(15)
    printlnResult(19)
    printlnResult(190)
    printlnResult(191)
    printlnResult(1000)
}

/**
 * Questions 44: A number sequence is: 0123456789101112131415..., find the number of index n
 */
private fun findNIndexNum(n: Int): Int {
    var minuend = n
    var amount = 0
    var sum = amount
    var bit = 1
    while (true) {
        val newAmount = if (amount == 0) 9 else amount * 10
        val subtrahend = newAmount * bit
        if (minuend - subtrahend > 0) {
            minuend -= subtrahend
            amount = newAmount
            sum += amount
            bit++
        } else
            break
    }
    val rem = minuend % bit
    val number = minuend / bit
    return if (rem == 0) (sum + number) % 10 else (sum + number + 1) / 10f.pow(bit - rem).toInt() % 10
}

private fun printlnResult(n: Int) =
    println("The ${n}th number is ${findNIndexNum(n)}")
