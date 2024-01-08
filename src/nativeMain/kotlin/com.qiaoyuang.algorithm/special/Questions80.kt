package com.qiaoyuang.algorithm.special

fun test80() {
    printlnResult(3, 2)
}

/**
 * Questions 80: Input integers n and k, find all sets that size is k and be combined by integers in 1...n
 */
private fun allSets(n: Int, k: Int): List<List<Int>> {
    require(n > 0) { "The n must grater than 0" }
    if (k == 0)
        return listOf(listOf())
    val nums = IntArray(n) { it + 1 }
    return buildList {
        nums.backtrack(0, this, mutableListOf(), k)
    }
}

private fun IntArray.backtrack(index: Int, results: MutableList<List<Int>>, subset: MutableList<Int>, k: Int) {
    if (subset.size == k)
        results.add(ArrayList(subset))
    else if (index < size) {
        backtrack(index + 1, results, subset, k)
        subset.add(this[index])
        backtrack(index + 1, results, subset, k)
        subset.removeLast()
    }
}

private fun printlnResult(n: Int, k: Int) =
    println("Input n = $n, k = $k, the all subsets are: ${allSets(n, k)}")