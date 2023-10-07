package com.qiaoyuang.algorithm.round1

import com.qiaoyuang.algorithm.round0.exchange

fun test45() {
    printlnResult(intArrayOf(3, 32, 321))
    printlnResult(intArrayOf(111, 123, 321))
}

/**
 * Questions 45: Give an IntArray, append all integer and find the smallest number that appended
 */
private fun findSmallestNumber(array: IntArray): String {
    require(array.isNotEmpty()) { "The array can't be empty" }
    array.quickSortByQuestions45()
    return buildString {
        array.forEach {
            append(it)
        }
    }
}

private object MyComparator : Comparator<Int> {
    override fun compare(a: Int, b: Int): Int {
        val aStr = a.toString()
        val bStr = b.toString()
        var aIndex = 0
        var bIndex = 0
        do {
            val aCurrent = aStr[aIndex++].digitToInt()
            val bCurrent = bStr[bIndex++].digitToInt()
            if (aCurrent == bCurrent) {
                if (aIndex == aStr.length && bIndex != bStr.length)
                    aIndex = 0
                if (aIndex != aStr.length && bIndex == bStr.length)
                    bIndex = 0
                continue
            } else
                return aCurrent - bCurrent
        } while (aIndex < aStr.length && bIndex < bStr.length)
        return 0
    }
}

private fun IntArray.quickSortByQuestions45() {
    quickSort(0, this.size - 1, MyComparator)
}

private fun IntArray.quickSort(low: Int, height: Int, comparator: Comparator<Int>) {
    if (height <= low) return
    val mid = partition(low, height, comparator)
    quickSort(low, mid - 1, comparator)
    quickSort(mid + 1, height, comparator)
}

private fun IntArray.partition(low: Int, height: Int, comparator: Comparator<Int>): Int {
    var i = low
    var j = height + 1
    while (true) {
        while (comparator.compare(this[++i], this[low]) < 0)
            if (i == height) break
        while (comparator.compare(this[low], this[--j]) < 0)
            if (j == low) break
        if (i >= j) break
        exchange(i, j)
    }
    exchange(low, j)
    return j
}

private fun printlnResult(array: IntArray) =
    println("Give the Array: ${array.toList()}, appended all of the integers, the smallest number is: ${findSmallestNumber(array)}")
