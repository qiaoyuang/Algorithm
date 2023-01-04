package com.qiaoyuang.algorithm.round1

fun test4() {
    val array0 = arrayOf(
        intArrayOf(1, 2, 4, 6),
        intArrayOf(2, 4, 7, 8),
        intArrayOf(8, 9, 10, 11),
        intArrayOf(9, 12, 13, 15),
    )
    val number0 = 7
    println("If the number $number0 in array0: ${array0 findNumberInTwoDimensionalArray number0}")
    val number1 = 5
    println("If the number $number1 in array0: ${array0 findNumberInTwoDimensionalArray number1}")
    val number2 = 15
    println("If the number $number2 in array0: ${array0 findNumberInTwoDimensionalArray number2}")
    val number3 = 16
    println("If the number $number3 in array0: ${array0 findNumberInTwoDimensionalArray number3}")
    val number4 = 9
    println("If the number $number4 in array0: ${array0 findNumberInTwoDimensionalArray number4}")
    val number5 = 6
    println("If the number $number5 in array0: ${array0 findNumberInTwoDimensionalArray number5}")
    println("If the number $number5 in empty array: ${emptyArray<IntArray>() findNumberInTwoDimensionalArray number5}")
}

/**
 * Questions4: Give a two-dimensional array and an integer, the two-dimensional array's row and column are increment.
 * If the integer in the two-dimensional array?
 */

private infix fun Array<IntArray>.findNumberInTwoDimensionalArray(number: Int): Boolean =
    if (isEmpty())
        false
    else
        findNumberInTwoDimensionalArray(number, lastIndex, 0)

private tailrec fun Array<IntArray>.findNumberInTwoDimensionalArray(number: Int, i: Int, j: Int): Boolean = when {
    i < 0 -> false
    j > this[i].lastIndex -> false
    else -> {
        val rightTop = this[i][j]
        when {
            rightTop > number -> findNumberInTwoDimensionalArray(number, i - 1, j)
            rightTop < number -> findNumberInTwoDimensionalArray(number, i, j + 1)
            else -> true
        }
    }
}