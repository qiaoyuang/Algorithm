package com.qiaoyuang.algorithm.special

fun test10() {
    printlnResult(intArrayOf(1, 1, 1), 2)
    printlnResult(intArrayOf(1, 3, 5, 4, -2, 2, 7), 9)
}

/**
 * Questions 10: Give an IntArray and an integer k, find the count of consistent sub-arrays in the IntArray that sum equals k
 */
private infix fun IntArray.findCount(k: Int): Int {
    require(isNotEmpty()) { "The IntArray can't be empty" }
    var count = 0
    repeat(size) { i ->
        var j = i
        while (j < size)
            if (subSum(i, j++) == k)
                count++
    }
    return count
}

private fun IntArray.subSum(i: Int, j: Int): Int {
    var sum = 0
    for (index in i..j)
        sum += this[index]
    return sum
}

private fun printlnResult(array: IntArray, k: Int) =
    println("The count of consistent sub-arrays that sum equals $k is (${array findCount k}) in array: ${array.toList()}")
