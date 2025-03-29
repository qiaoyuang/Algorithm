package com.qiaoyuang.algorithm.special

fun test104() {
    printlnResult(intArrayOf(1, 2, 3), 3)
    printlnResult(intArrayOf(1, 2, 3, 4), 5) // 15
}

/**
 * Questions 104: Combination Sum IV, LeetCode 377
 */
private fun countOfPermutation(nums: IntArray, t: Int): Int {
    val db = IntArray(t + 1)
    db[0] = 1 // An empty permutation could make the sum equals 0
    for (i in 1..t)
        nums.forEach { num ->
            if (i >= num)
                db[i] += db[i - num]
        }
    return db.last()
}

private fun printlnResult(nums: IntArray, t: Int) =
    println("We can find the ${countOfPermutation(nums, t)} different permutations that could make their sum equals $t in IntArray: ${nums.toList()}")