package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.Stack

fun test36() {
    printlnResult('5', '1', '2', '+', '4', '*', '+', '3', '-')
    printlnResult('2', '1', '3', '*', '+')
    printlnResult('2', '1', '+', '3', '*')
}

/**
 * Questions 36: Reverse Polish Notation
 */
private fun CharArray.calculateReversePolishNotation(): Int {
    val charStack = Stack<Int>()
    forEach {
        when (it) {
            '+' -> {
                val second = charStack.pop()
                val first = charStack.pop()
                val result = first + second
                charStack.push(result)
            }
            '-' -> {
                val second = charStack.pop()
                val first = charStack.pop()
                val result = first - second
                charStack.push(result)
            }
            '*' -> {
                val second = charStack.pop()
                val first = charStack.pop()
                val result = first * second
                charStack.push(result)
            }
            '/' -> {
                val second = charStack.pop()
                val first = charStack.pop()
                val result = first / second
                charStack.push(result)
            }
            else -> charStack.push(it.digitToInt())
        }
    }
    return charStack.pop()
}

private fun printlnResult(vararg notation: Char) =
    println("Calculate the notation: ${notation.toList()}, we got ${notation.calculateReversePolishNotation()}")