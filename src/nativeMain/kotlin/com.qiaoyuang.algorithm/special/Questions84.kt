package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.exchange

fun test84() {
    printlnResult(1, 1, 2)
}

/**
 * Questions 84: Find the full permutation of an IntArray that contain repeated integers possibly
 */
private fun IntArray.fullPermutation(): List<List<Int>> = buildList {
    backTrack(this, this@fullPermutation, 0)
}

private fun backTrack(results: MutableList<List<Int>>, permutation: IntArray, i: Int) {
    if (i == permutation.size)
        results.add(permutation.toList())
    else {
        var j = i
        while (j < permutation.size) {
            permutation.exchange(i, j)
            backTrack(results, permutation, i + 1)
            permutation.exchange(i, j)
            j = findNext(permutation, i, j)
        }
    }
}

private fun findNext(permutation: IntArray, i: Int, j: Int): Int {
    var next = j + 1
    while (next < permutation.size && permutation[i] == permutation[next])
        next++
    return next
}

private fun printlnResult(vararg nums: Int) =
    println("The full permutations of ${nums.toList()} are ${nums.fullPermutation()}")