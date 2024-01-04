package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.partition

fun test76() {
    printlnResult(intArrayOf(3, 1, 2, 4, 5, 5, 6), 3)
}

/**
 * Questions 76: Find the kth big number in an IntArray
 */
private infix fun IntArray.findKthLargest(k: Int): Int {
    require(isNotEmpty() && k in 1 ..< size) { "The k must less than size of the IntArray and greater than 0" }
    var start = 0
    var end = lastIndex
    var index = partition(start, end)
    val indexK = size - k
    while (index != indexK) {
        if (index > indexK)
            end = index - 1
        else
            start = index + 1
        index = partition(start, end)
    }
    return this[indexK]
}

private fun printlnResult(array: IntArray, k: Int) =
    println("The kth largest number in IntArray: ${array.toList()} is: ${array findKthLargest k}")