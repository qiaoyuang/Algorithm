package com.qiaoyuang.algorithm.special

fun test8() {
    printlnResult(intArrayOf(5, 1, 4, 3), 7)
}

/**
 * Questions 8: Given an IntArray and an integer k, find the shortest continues sub-array that sum equals or greater than k
 */
private infix fun IntArray.findShortestSizeOfSubArray(k: Int): Int {
    require(isNotEmpty()) { "The IntArray can't be empty" }
    var shortestSize = 0
    repeat(size) { i ->
        var j = i + 1
        while (j < size) {
            val sum = subSum(i, j)
            if (sum >= k) {
                val newSize = j - i + 1
                if (shortestSize == 0 || newSize < shortestSize)
                    shortestSize = newSize
                break
            } else j++
        }
    }
    return shortestSize
}

private fun IntArray.subSum(i: Int, j: Int): Int {
    var sum = 0
    for (index in i..j)
        sum += this[index]
    return sum
}

private fun printlnResult(array: IntArray, k: Int) =
    println("The shortest size is ${array findShortestSizeOfSubArray k} of sub-array in IntArray: ${array.toList()} that sum equals or greater than $k")
