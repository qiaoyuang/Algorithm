package com.qiaoyuang.algorithm.round1

fun test53() {
    printlnResult1(3, intArrayOf(1, 2, 3, 3, 3, 3, 4, 5))
    printlnResult1(3, intArrayOf(3, 3, 3, 3, 4, 5, 6))
    printlnResult1(3, intArrayOf(1, 1, 2, 3, 3, 3, 3))
    printlnResult1(1, intArrayOf(1))
    printlnResult1(0, intArrayOf(1, 1, 1, 1, 1, 1))

    printlnResult2(intArrayOf(0, 1, 2, 3, 4, 6 ,7, 8, 9))
    printlnResult2(intArrayOf(1, 2, 3, 4, 5, 6 ,7, 8, 9))
    printlnResult2(intArrayOf(1))

    printlnResult3(intArrayOf(-3, -1, 1, 3, 5))
    printlnResult3(intArrayOf(0))
    printlnResult3(intArrayOf(0, 1, 2, 3, 4))
    printlnResult3(intArrayOf(-3, -1, 1, 3, 5, 9))
}

/**
 * Questions 53-1: Find the count of a number appears in a sorted IntArray.
 */
private infix fun IntArray.findCount(num: Int): Int {
    require(isNotEmpty()) { "The array can't be empty" }
    var firstIndex = -1
    var start = 0
    var mid = size / 2
    var end = lastIndex

    if (first() > num || last() < num)
        return 0

    while (mid in 0..lastIndex) {
        when {
            this[mid] > num -> {
                end = mid
                mid = (end - start) / 2 + start
            }
            this[mid] < num -> {
                start = mid + 1
                mid = (end - start) / 2 + start
            }
            else ->
                if (mid == 0 || this[mid - 1] != this[mid]) {
                    firstIndex = mid
                    break
                } else {
                    end = mid
                    mid = (end - start) / 2 + start
                }
        }
    }

    var lastIndex1 = -1
    start = 0
    mid = size / 2
    end = lastIndex
    while (mid in 0..lastIndex) {
        when {
            this[mid] > num -> {
                end = mid
                mid = (end - start) / 2 + start
            }

            this[mid] < num -> {
                start = mid + 1
                mid = (end - start) / 2 + start
            }

            else -> {
                if (mid == lastIndex || this[mid + 1] != this[mid]) {
                    lastIndex1 = mid
                    break
                } else {
                    start = mid + 1
                    mid = (end - start) / 2 + start
                }
            }
        }
    }
    return if (lastIndex1 >= 0 && firstIndex >= 0)
        lastIndex1 - firstIndex + 1
    else 0
}

private fun printlnResult1(num: Int, array: IntArray) =
    println("The number $num appear ${array findCount num} times in array: ${array.toList()}")

/**
 * Questions 52-2: There is a IntArray that's size is n-1, the numbers in the IntArray is sorted, and it begins with 0, ends with n,
 * and each number is different, find the number that the IntArray doesn't contain.
 */
private fun IntArray.findLeakedNumber(): Int {
    var start = 0
    var mid = size / 2
    var end = lastIndex
    while (mid in 0..lastIndex) {
        when {
            this[mid] == mid -> {
                start = mid + 1
                mid = (end - start) / 2 + start
            }
            mid == 0 || this[mid - 1] == mid - 1 -> return mid
            else -> {
                end = mid
                mid = (end - start) / 2 + start
            }
        }
    }
    throw IllegalArgumentException("The IntArray doesn't leak any number")
}

private fun printlnResult2(array: IntArray) = println("The array: ${array.toList()} leaks number ${array.findLeakedNumber()}")

/**
 * Questions 53-3: An IntArray monotonically increasing, each number is only one. Found the number that equals its index in the IntArray.
 */
private fun IntArray.findNumberThatEqualsIndex(): Int {
    require(isNotEmpty()) { "The IntArray can't be empty" }
    var start = 0
    var mid = size / 2
    var end = lastIndex
    while (mid in 0..lastIndex) {
        when {
            this[mid] == mid -> return mid
            mid == 0 || mid == lastIndex -> throw IllegalArgumentException("The IntArray doesn't contain the number that equals its index")
            this[mid] > mid -> {
                end = mid
                mid = (end - start) / 2 + start
            }
            this[mid] < mid -> {
                start = mid + 1
                mid = (end - start) / 2 + start
            }
        }
    }
    throw IllegalArgumentException("The IntArray doesn't contain the number that equals its index")
}

private fun printlnResult3(array: IntArray) = println("The number that equals its index in IntArray: ${array.toList()} is ${array.findNumberThatEqualsIndex()}")
