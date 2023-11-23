package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.Stack

fun test38() {
    printlnResult(35, 31, 33, 36, 34)
    printlnResult(35, 31, 33)
    printlnResult(30)
}

/**
 * Questions 38: Given an IntArray to represent the temperatures of every day.
 * Calculate how many days that everyday need to wait for higher temperature.
 */
private fun IntArray.higherTemperatures(): IntArray {
    val result = IntArray(size)
    val stack = Stack<Int>()
    forEachIndexed { index, temp ->
        if (stack.isEmpty || this[stack.top()] >= temp)
            stack.push(index)
        else {
            while (!stack.isEmpty && this[stack.top()] < temp)
                result[stack.top()] = index - stack.pop()
            stack.push(index)
        }
    }
    return result
}

private fun printlnResult(vararg temperatures: Int) {
    println("The temperatures for every day are: ${temperatures.toList()}, ")
    println("the days of higher temperature for every day are ${temperatures.higherTemperatures().toList()}")
}