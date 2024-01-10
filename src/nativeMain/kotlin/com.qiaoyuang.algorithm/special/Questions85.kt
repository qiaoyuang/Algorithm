package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.Stack

fun test85() {
    printlnResult(0)
    printlnResult(1)
    printlnResult(2)
    printlnResult(3)
    printlnResult(4)
}

/**
 * Questions 85: Given an integer n, that means n left parentheses and n right parentheses,
 * output the all combinations of parentheses
 */
private fun allCombinations(n: Int): List<String> = buildList {
    backTrack(StringBuilder(), n, 0, 0)
}

private fun MutableList<String>.backTrack(builder: StringBuilder, n: Int, left: Int, right: Int) {
    val i = left + right
    if (i == n shl 1) {
        if (builder.judge())
            add(builder.toString())
    } else {
        if (left < n) {
            builder.append('(')
            backTrack(builder, n, left + 1, right)
            builder.deleteAt(builder.lastIndex)
        }
        if (right < n) {
            builder.append(')')
            backTrack(builder, n, left, right + 1)
            builder.deleteAt(builder.lastIndex)
        }
    }
}

private fun StringBuilder.judge(): Boolean {
    val stack = Stack<Char>()
    forEach {
        when (it) {
            '(' -> stack.push(it)
            ')' -> if (stack.isEmpty) return false else stack.pop()
        }
    }
    return stack.isEmpty
}

private fun printlnResult(n: Int) =
    println("The full combinations of $n parentheses are ${allCombinations(n)}")