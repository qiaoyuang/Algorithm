package com.qiaoyuang.algorithm.special

fun test81() {
    printlnResult(intArrayOf(3, 5, 2), 8)
    printlnResult(intArrayOf(2, 3, 5), 10)
}

/**
 * Questions 81: Given an IntArray that doesn't contain the same integers. And, given a value,
 * please find all subsets that the sum of subset equals this value, integers could appear any times in one subset
 */
private infix fun IntArray.findSubsets(sum: Int): List<List<Int>> = buildList {
    backTrack(this, mutableListOf(), sum, 0)
}

private fun IntArray.backTrack(results: MutableList<List<Int>>, subset: MutableList<Int>, sum: Int, index: Int) {
    if (sum == 0) {
        results.add(listOf())
        return
    }
    if (sum < 0) return
    val sumOfSubset = subset.sum()
    when {
        sumOfSubset > sum -> return
        sumOfSubset == sum -> {
            results.add(ArrayList(subset))
            return
        }
    }

    if (index >= size) return

    backTrack(results, subset, sum, index + 1)

    subset.add(this[index])
    backTrack(results, subset, sum, index)
    subset.removeLast()
}

private fun printlnResult(nums: IntArray, sum: Int) =
    println("The all subsets in ${nums.toList()} that sum equals $sum are ${nums findSubsets sum}")