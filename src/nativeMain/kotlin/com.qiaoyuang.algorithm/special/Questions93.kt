package com.qiaoyuang.algorithm.special

import androidx.collection.mutableIntIntMapOf

fun test93() {
    printlnResult(1, 2, 3, 4, 5, 6, 7, 8, 50)
}

/**
 * Questions 93: The longest Fibonacci sequence
 */
private fun IntArray.longestFibonacci(): Int {
    require(size >= 3) { "The input IntArray is illegal" }
    val db = Array(size) { IntArray(it + 1) }
    val map = mutableIntIntMapOf()
    forEachIndexed { i, num ->
        map[num] = i
    }
    var result = 0
    for (i in 2 ..< size)
        for (j in 1 ..< i) {
            val k = map.getOrDefault(this[i] - this[j], -1)
            if (k in 0 ..< j)
                db[i][j] = if (db[j][k] == 0)
                    3
                else
                    db[j][k] + 1
            if (db[i][j] > result)
                result = db[i][j]
        }
    return result
}

private fun printlnResult(vararg nums: Int) =
    println("The length of longest Fibonacci sequence is ${nums.longestFibonacci()} in ${nums.toList()}")
