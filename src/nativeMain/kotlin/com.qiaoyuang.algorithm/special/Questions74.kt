package com.qiaoyuang.algorithm.special

import kotlin.math.max

fun test74() {
    printlnResult(1..3, 4..5, 8..10, 2..6, 9..12, 15..18)
}

/**
 * Questions 74: Merge Intervals, LeetCode 56
 */
private fun List<IntRange>.merge(): List<IntRange> =
    sortedBy { it.first }.fold(mutableListOf()) { acc, intRange ->
        if (acc.isEmpty()) {
            acc.add(intRange)
        } else {
            val last = acc.last()
            if (last.last >= intRange.first) {
                acc.removeLast()
                acc.add(last.first..max(intRange.last, last.last))
            } else
                acc.add(intRange)
        }
        acc
    }

private fun printlnResult(vararg intRange: IntRange) {
    val list = intRange.toList()
    println("Merge the ranges $list, we can get ${list.merge()}")
}