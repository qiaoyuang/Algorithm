package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.PriorityQueue
import kotlin.math.min

fun test61() {
    printlnResult(intArrayOf(1, 5, 13, 21), intArrayOf(2, 4, 9, 15), 3)
}

/**
 * Questions 61: Given two increased IntArrays, find the k integers pair that sum is minimum
 */
private fun minPairs(a: IntArray, b: IntArray, k: Int): List<Pair<Int, Int>> {
    val queue = PriorityQueue<IntArrayComparable>()
    for (i in 0 ..< min(k, a.size)) {
        queue.enqueue(IntArrayComparable(intArrayOf(i, 0), a, b))
    }
    var count = k
    return buildList {
        while (count-- > 0 && !queue.isEmpty) {
            val (i, j) = queue.dequeue().intArray
            add(a[i] to b[j])
            if (j < b.lastIndex)
                queue.enqueue(IntArrayComparable(intArrayOf(i, j + 1), a, b))
        }
    }
}

class IntArrayComparable(
    val intArray: IntArray,
    val a: IntArray,
    val b: IntArray,
) : Comparable<IntArrayComparable> {
    override fun compareTo(other: IntArrayComparable): Int =
        a[other.intArray.first()] + b[other.intArray.last()] - a[intArray.first()] - b[intArray.last()]
}

private fun printlnResult(a: IntArray, b: IntArray, k: Int) =
    println("The minimum number pairs are: ${minPairs(a, b, k)}")