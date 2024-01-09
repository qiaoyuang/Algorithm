package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.exchange

fun test83() {
    printlnResult(1, 2, 3)
}

/**
 * Questions 83: Find the full permutation of an IntArray that doesn't contain any repeated integer
 */
private fun IntArray.fullPermutation(): List<List<Int>> = buildList {
    backTrack(this, this@fullPermutation, 0)
}

private fun backTrack(results: MutableList<List<Int>>, permutation: IntArray, i: Int) {
    if (i == permutation.size)
        results.add(permutation.toList())
    else
        for (j in i ..< permutation.size) {
            permutation.exchange(i, j)
            backTrack(results, permutation, i + 1)
            permutation.exchange(i, j)
        }
}

private fun printlnResult(vararg nums: Int) =
    println("The full permutation of ${nums.toList()} are ${nums.fullPermutation()}")