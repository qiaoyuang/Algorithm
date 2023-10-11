package com.qiaoyuang.algorithm.round1

import com.qiaoyuang.algorithm.round0.partition

fun test39() {
    printlnResult(intArrayOf(1, 2, 3, 2, 2, 2, 5, 4, 2))
    printlnResult(intArrayOf(0, 9, 9, 8, 2, 9, 5, 9, 9))
}

/**
 * Questions 39: Find the number that more than a half in an IntArray
 */
private fun IntArray.findTheNumber1(): Int {
    require(isNotEmpty()) { "The IntArray can't be empty" }
    var num = first()
    if (size == 1)
        return num
    var count = 1
    for (i in 1..< size) {
        val current = this[i]
        when {
            current == num -> count++
            --count == 0 -> {
                num = current
                count = 1
            }
        }
    }
    require(count > 0) { "The IntArray must contain a number that more than a half" }
    return num
}

private fun IntArray.findTheNumber2(): Int {
    require(isNotEmpty()) { "The IntArray can't be empty" }
    val mid = size shr 1
    var start = 0
    var end = lastIndex
    var index = partition(start, end)
    while (index != mid) {
        if (index > mid)
            end = index - 1
        else
            start = index + 1
        index = partition(start, end)
    }
    return this[mid].takeIf { checkMoreThanHalf(it) } ?: throw IllegalArgumentException("The IntArray must contain a number that more than a half")
}

private infix fun IntArray.checkMoreThanHalf(target: Int): Boolean {
    var count = 0
    val half = size shr 1
    forEach {
        if (it == target && ++count > half)
            return true
    }
    return false
}

private fun printlnResult(intArray: IntArray) {
    println("The number in IntArray: ${intArray.toList()} that more than a half is ${intArray.findTheNumber1()}")
    println("The number in IntArray: ${intArray.toList()} that more than a half is ${intArray.findTheNumber2()}")
}
