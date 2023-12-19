package com.qiaoyuang.algorithm.special

fun test69() {
    printlnResult(1, 3, 5, 4, 2)
    printlnResult(0, 1, 8, 6, 5, 3, 2, 1, 0)
}

/**
 * Questions 69: An IntArray that size greater or equals 3, the first part of this IntArray
 * is increased, and second part is decreased, find the index of peek of this IntArray.
 */
private fun IntArray.findPeek(): Int {
    var start = 0
    var end = lastIndex
    while (start < end) {
        val mid = (end - start) / 2 + start
        if (this[mid] > this[mid + 1]) {
            end = mid
        } else {
            start = mid + 1
        }
    }
    return start
}

private fun printlnResult(vararg nums: Int) =
    println("The index of peek in IntArray ${nums.toList()} is ${nums.findPeek()}")