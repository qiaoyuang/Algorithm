package com.qiaoyuang.algorithm.special

fun test82() {
    printlnResult(intArrayOf(2, 2, 2, 4, 3, 3), 8)
}

/**
 * Questions 82: Given an IntArray that contain the same integers possibly. And, given a value,
 * please find all subsets that the sum of subset equals this value, integers just could appear once in one subset
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

    backTrack(results, subset, sum, getNext(index))

    subset.add(this[index])
    backTrack(results, subset, sum, index + 1)
    subset.removeLast()
}

private infix fun IntArray.getNext(i: Int): Int {
    for (j in i + 1 ..< size)
        if (this[i] != this[j])
            return j
    return size
}

private fun printlnResult(nums: IntArray, sum: Int) =
    println("The all subsets in ${nums.toList()} that sum equals $sum are ${nums findSubsets sum}")