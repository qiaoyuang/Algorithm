package com.qiaoyuang.algorithm.special

fun test102() {
    printlnResult(intArrayOf(2, 2, 2), 2)
}

/**
 * Questions 102: Given an IntArray that the numbers are greater than 0 and a target integer S,
 * use addition or subtraction to each number, hom many methods that could make the result to equal S
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
    val p = (s + array.sum()) shr 1
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