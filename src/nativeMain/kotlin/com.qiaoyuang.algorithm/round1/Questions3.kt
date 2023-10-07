package com.qiaoyuang.algorithm.round1

import com.qiaoyuang.algorithm.round0.exchange

fun test3() {
    val numbers0 = intArrayOf(2, 3, 1, 0, 2, 5, 3)
    val numbers1 = intArrayOf(2, 3, 5, 4, 3, 2, 6, 7)
    println("The repeat number is: ${findNumber1(numbers0)}")
    println("The repeat number is: ${findNumber1(numbers1)}")
    println("The repeat number is: ${findNumber21(numbers1)}")
    println("The repeat number is: ${findNumber22(numbers1)}")
}

/**
 * Questions 3-1: Find the repeat number in IntArray, the numbers between 0~n-1
 */

private fun findNumber1(numbers: IntArray): Int {
    numbers.forEachIndexed { index, i ->
        if (index != i) {
            if (i == numbers[i])
                return i
            else
                numbers.exchange(index, i)
        }
    }
    throw IllegalArgumentException("This IntArray doesn't have repeat number")
}

/**
 * Questions 3-2: Find the repeat number in IntArray,
 * the IntArray.length == n + 1, the numbers between 1~n-1,
 * but can't modify the IntArray.
 */

private fun findNumber21(numbers: IntArray): Int {
    val helpArray = IntArray(numbers.size) { 0 }
    numbers.forEach {
        if (helpArray[it] == it)
            return it
        else
            helpArray[it] = it
    }
    throw IllegalArgumentException("This IntArray doesn't have repeat number")
}

private fun findNumber22(numbers: IntArray): Int {
    var start = 1
    var end = numbers.lastIndex
    while (end >= start) {
        val middle = ((end - start) shr 1) + start
        val count = numbers countRange start..middle
        if (end == start) {
            if (count > 1)
                return start
            else
                break
        }
        if (count > (middle - start + 1))
            end = middle
        else
            start = middle + 1
    }
    throw IllegalArgumentException("The 'numbers' doesn't have repeat numbers")
}

private infix fun IntArray.countRange(range: IntRange): Int = fold(0) { acc, number ->
    if (number in range)
        acc + 1
    else
        acc
}