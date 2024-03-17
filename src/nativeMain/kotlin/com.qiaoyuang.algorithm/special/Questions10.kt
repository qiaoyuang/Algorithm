package com.qiaoyuang.algorithm.special

fun test10() {
    printlnResult(intArrayOf(1, 1, 1), 2)
    printlnResult(intArrayOf(1, 3, 5, 4, -2, 2, 7), 9)
}

/**
 * Questions 10: Give an IntArray and an integer k, find the count of consistent sub-arrays in the IntArray that sum equals k
 */
private fun findCount(array: IntArray, k: Int): Int {
    require(array.isNotEmpty()) { "The IntArray can't be empty" }
    val sumToCount = HashMap<Int, Int>()
    sumToCount[0] = 1
    var sum = 0
    var count = 0
    array.forEach {
        sum += it
        count += sumToCount[sum - k] ?: 0
        sumToCount[sum] = (sumToCount[sum] ?: 0) + 1
    }
    return count
}

private fun printlnResult(array: IntArray, k: Int) =
    println("The count of consistent sub-arrays that sum equals $k is (${findCount(array, k)}) in array: ${array.toList()}")
