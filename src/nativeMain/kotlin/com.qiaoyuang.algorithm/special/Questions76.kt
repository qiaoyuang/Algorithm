package com.qiaoyuang.algorithm.special

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
    var index = partition(nums, start, end)
    val indexK = nums.size - k
    while (index != indexK) {
        if (index > indexK)
            end = index - 1
        else
            start = index + 1
        index = partition(nums, start, end)
    }
    return nums[index]
}

private fun partition(nums: IntArray, low: Int, height: Int): Int {
    if (low >= height)
        return low
    var i = low + 1
    var j = height
    while (true) {
        while (nums[i++] < nums[low])
            if (i == height)
                break
        while (nums[low] < nums[j--])
            if (j == low)
                break
        if (i >= j)
            break
        swap(nums, i, j)
    }
    swap(nums, low, j)
    return j
}

private fun swap(nums: IntArray, i: Int, j: Int) {
    val temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp
}

private fun printlnResult(array: IntArray, k: Int) =
    println("The kth largest number in IntArray: ${array.toList()} is: ${findKthLargest(array, k)}")