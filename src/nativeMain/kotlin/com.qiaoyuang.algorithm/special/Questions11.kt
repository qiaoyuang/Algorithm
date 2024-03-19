package com.qiaoyuang.algorithm.special

fun test11() {
    printlnResult(intArrayOf(1, 0, 1))
    printlnResult(intArrayOf(1, 1, 0, 1))
    printlnResult(intArrayOf(1, 1, 0, 1, 0, 0, 1))
}

/**
 * Questions 11: Find the counts of consistent sub-arrays that their counts of
 * 1 and 0 equal in an IntArray that just contain 0 and 1, and the sub-arrays
 * contain 2 elements at least.
 */
private fun findCountOf0and1(nums: IntArray): Int {
    require(nums.size > 2) { "The size of IntArray must greater than 2" }
    val map = HashMap<Int, Int>(nums.size)
    var sum = 0
    var maxLength = 0
    nums.forEachIndexed { i, num ->
        sum += if (num == 0) -1 else 1
        if (map.containsKey(sum)) {
            val length = i - map[sum]!!
            if (length > maxLength)
                maxLength = length
        } else
            map[sum] = i
    }
    return maxLength
}

private fun printlnResult(array: IntArray) =
    println("The count of consistent sub-arrays that counts of 0 and 1 equal is (${findCountOf0and1(array)}) in array: ${array.toList()}")
