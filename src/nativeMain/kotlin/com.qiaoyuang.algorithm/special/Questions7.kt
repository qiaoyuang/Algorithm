package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.quickSort

fun test7() {
    printlnResult(intArrayOf(-1, 0, 1, 2, -1, -4))
    printlnResult(intArrayOf(-2, 0, -2, 1, -1, 2, 3, 4))
}

/**
 * Questions 7: Find all the three numbers in an IntArray that theirs sum is 0.
 */
private fun IntArray.findThreeNumbers(): List<Triple<Int, Int, Int>> {
    require(size > 2) { "The size of the IntArray must greater than 2" }
    quickSort()
    val nums = this
    return buildList {
        var i = 0
        while (i < nums.size - 2) {
            var j = i + 1
            var k = nums.lastIndex
            while (j < k) {
                val sum = nums[i] + nums[j] + nums[k]
                when {
                    sum < 0 -> {
                        val currentJ = nums[j++]
                        while (j < k && currentJ == nums[j])
                            j++
                    }
                    sum > 0 -> {
                        val currentK = nums[k--]
                        while (j < k && currentK == nums[k])
                            k--
                    }
                    else -> {
                        add(Triple(nums[i], nums[j], nums[k]))
                        val currentJ = nums[j++]
                        while (j < k && currentJ == nums[j])
                            j++
                        val currentK = nums[k--]
                        while (j < k && currentK == nums[k])
                            k--
                    }
                }
            }
            val currentI = nums[i++]
            while (i < nums.size - 2 && currentI == nums[i])
                i++
        }
    }
}

private fun printlnResult(array: IntArray) {
    println("The all of the three numbers in IntArray: ${array.toList()} are:")
    println("(${array.findThreeNumbers()})")
    println("That theirs sum is 0.")
}
