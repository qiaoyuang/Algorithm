package com.qiaoyuang.algorithm.special

fun test79() {
    printlnResult(1, 2, 3)
    printlnResult(5, 6, 7, 8)
}

/**
 * Questions 79: Input an IntArray that doesn't contain repeated elements, find the all subsets
 */
private fun allSubSets(nums: IntArray): List<List<Int>> = buildList {
    if (nums.isNotEmpty())
        nums.backtrack(this, 0, mutableListOf())
}

private fun IntArray.backtrack(mutableList: MutableList<List<Int>>, index: Int, subset: MutableList<Int>) {
    if (index == size) {
        mutableList.add(ArrayList(subset))
    } else {
        backtrack(mutableList, index + 1, subset)
        subset.add(this[index])
        backtrack(mutableList, index + 1, subset)
        subset.removeLast()
    }
}
private fun printlnResult(vararg nums: Int) {
    println("Input an IntArray: ${nums.toList()}")
    println("The all of combinations are: ${allSubSets(nums)}")
}