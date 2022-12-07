package com.qiaoyuang.algorithm.round1

import com.qiaoyuang.algorithm.round0.exchange

fun test3() {
    val numbers0 = intArrayOf(2, 3, 1, 0, 2, 5, 3)
    val numbers1 = intArrayOf(2, 3, 5, 4, 3, 2, 6, 7)
    println("The repeat number is: ${findNumber1(numbers0)}")
    println("The repeat number is: ${findNumber1(numbers1)}")
    println("The repeat number is: ${findNumber21(numbers1)}")
}

/**
 * Question 3-1: Find the repeat number in IntArray, the numbers between 0~n-1
 */

fun findNumber1(numbers: IntArray): Int {
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
 * Question 3-2: Find the repeat number in IntArray,
 * the IntArray.length == n + 1, the numbers between 1~n-1,
 * but can't modify the IntArray.
 */

fun findNumber21(numbers: IntArray): Int {
    val helpArray = IntArray(numbers.size) { 0 }
    numbers.forEach {
        if (helpArray[it] == it)
            return it
        else
            helpArray[it] = it
    }
    throw IllegalArgumentException("This IntArray doesn't have repeat number")
}

fun findNumber22(numbers: IntArray): Int = binarySearch(numbers, 0, numbers.lastIndex)

private fun binarySearch(array: IntArray, start: Int, end: Int): Int {

}