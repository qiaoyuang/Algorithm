package com.qiaoyuang.algorithm.special

fun test104() {
    printlnResult(intArrayOf(1, 2, 3), 3)
    printlnResult(intArrayOf(1, 2, 3, 4), 5) // 15
}

/**
 * Questions 104: Given an IntArray, all the numbers are different,
 * find the count of permutations, that their sums equal integer t
 */
private fun countOfPermutation(nums: IntArray, t: Int): Int {
    val db = IntArray(t + 1)
    for (i in 1..t)
        nums.forEach { num ->
            if (i == num)
                db[i] += 1
            else if (i > num)
                db[i] += db[i - num]
        }
    return db.last()
}

private fun printlnResult(nums: IntArray, t: Int) =
    println("We can find the ${countOfPermutation(nums, t)} different permutations that could make their sum equals $t in IntArray: ${nums.toList()}")