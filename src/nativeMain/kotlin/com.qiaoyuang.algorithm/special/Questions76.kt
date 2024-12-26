package com.qiaoyuang.algorithm.special

import kotlin.random.Random

fun test76() {
    printlnResult(intArrayOf(3, 1, 2, 4, 5, 5, 6), 3)
    printlnResult(intArrayOf(1, 2, 3, 4, 5, 6), 1)
}

/**
 * Questions 76: Find the kth big number in an IntArray
 */
private fun findKthLargest(nums: IntArray, k: Int): Int {
    var start = 0
    var end = nums.lastIndex
    var index = partition2(nums, start, end)
    val indexK = nums.size - k
    while (index != indexK) {
        if (index > indexK)
            end = index - 1
        else
            start = index + 1
        index = partition2(nums, start, end)
    }
    return nums[index]
}

private fun partition(nums: IntArray, low: Int, height: Int): Int {
    if (low >= height)
        return low
    var i = low
    var j = height + 1
    while (true) {
        while (nums[++i] < nums[low])
            if (i >= height)
                break
        while (nums[low] < nums[--j])
            if (j <= low)
                break
        if (i >= j)
            break
        swap(nums, i, j)
    }
    swap(nums, low, j)
    return j
}

private fun partition2(nums: IntArray, start: Int, end: Int): Int {
    val random = Random.nextInt(end - start + 1) + start
    swap(nums, random, end)
    var small = start - 1
    for (i in start ..< end) {
        if (nums[i] < nums[end]) {
            small++
            swap(nums, i, small)
        }
    }
    small++
    swap(nums, small, end)
    return small
}

private fun swap(nums: IntArray, i: Int, j: Int) {
    val temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp
}

private fun printlnResult(array: IntArray, k: Int) =
    println("The ${k}th largest number in IntArray: ${array.toList()} is: ${findKthLargest(array, k)}")