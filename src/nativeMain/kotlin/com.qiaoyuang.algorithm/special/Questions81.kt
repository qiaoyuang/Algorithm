package com.qiaoyuang.algorithm.special

fun test81() {
    printlnResult(intArrayOf(3, 5, 2), 8)
    printlnResult(intArrayOf(2, 3, 5), 10)
}

/**
 * Questions 81: Combination Sum, LeetCode 39
 */
private infix fun IntArray.findSubsets(target: Int): List<List<Int>> = buildList {
    backTrack(this, mutableListOf(), target, 0, 0)
}

private fun IntArray.backTrack(results: MutableList<List<Int>>, subset: MutableList<Int>, target: Int, sum: Int, index: Int) {
    if (target == 0) {
        results.add(listOf())
        return
    }
    if (target < 0) return
    when {
        sum > target -> return
        sum == target -> {
            results.add(ArrayList(subset))
            return
        }
    }

    if (index >= size) return

    backTrack(results, subset, target, sum,index + 1)

    subset.add(this[index])
    backTrack(results, subset, target, sum + this[index], index)
    subset.removeLast()
}

private fun printlnResult(nums: IntArray, sum: Int) =
    println("The all subsets in ${nums.toList()} that sum equals $sum are ${nums findSubsets sum}")