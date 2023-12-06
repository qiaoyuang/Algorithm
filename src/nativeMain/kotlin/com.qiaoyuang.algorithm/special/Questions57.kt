package com.qiaoyuang.algorithm.special

fun test57() {
    printlnResult(intArrayOf(1, 2, 3, 1), 3, 0)
    printlnResult(intArrayOf(1, 5, 9, 1, 5, 9), 2, 3)
}

/**
 * Questions 57: Given an IntArray nums, and two positive integer t and k,
 * find the two indexes i and j that abs(i - j) <= k, and abs(nums[i] - nums[j]) <= t.
 */
private fun findIndexes(nums: IntArray, k: Int, t: Int): Boolean {
    val bucketSize = t + 1
    val buckets = HashMap<Int, Int>(bucketSize)
    nums.forEachIndexed { i, num ->
        val id = getBucketID(num, bucketSize)

        if (buckets.contains(id)
            || (buckets.contains(id - 1) && buckets[id - 1]!! + t >= num)
            || (buckets.contains(id + 1) && buckets[id + 1]!! - t <= num))
            return true

        buckets[id] = num
        if (i >= k)
            buckets.remove(getBucketID(nums[i - k], bucketSize))
    }
    return false
}

private fun getBucketID(num: Int, bucketSize: Int): Int =
    if (num >= 0) num / bucketSize else (num + 1) / (bucketSize - 1)

private fun printlnResult(nums: IntArray, k: Int, t: Int) =
    println("In IntArray ${nums.toList()}, k = $k, t = $t, is the two indexes exit: ${findIndexes(nums, k, t)}")