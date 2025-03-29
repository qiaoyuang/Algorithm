package com.qiaoyuang.algorithm.special

fun test102() {
    printlnResult(intArrayOf(2, 2, 2), 2)
}

/**
 * Questions 102: Target Sum, LeetCode 494
 */
private fun findMethods(array: IntArray, s: Int): Int {
    val p = (s + array.sum()) shr 1
    val db = Array(array.size) { IntArray(p + 1) }
    db.forEach { it[0] = 1 }
    for (i in 1 ..< array.size)
        for (j in 1..p) {
            db[i][j] = db[i - 1][j]
            if (j >= array[i])
                db[i][j] += db[i][j - array[i]]
        }
    return db.last().last()
}

private fun findMethods2(array: IntArray, s: Int): Int {
    val sum = array.sum()
    if ((sum + s) % 2 == 1 || sum < s)
        return 0
    val db = IntArray(s + 1)
    db[0] = 1
    array.forEach { num ->
        for (j in s downTo num)
            if (j >= num)
                db[j] += db[j - num]
    }
    return db[s]
}

private fun printlnResult(nums: IntArray, s: Int) =
    println("There are ${findMethods(nums, s)}, ${findMethods2(nums, s)} methods that could make the addition or subtraction result equal $s")