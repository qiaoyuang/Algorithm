package com.qiaoyuang.algorithm.round1

fun test33() {
    printlnResult(5, 7, 6, 9, 11, 10, 8) // true
    printlnResult(5, 7, 6, 11, 10, 8) // true
    printlnResult(7, 4, 6, 5) // false
    printlnResult(5, 6, 11, 10, 8) // true
    printlnResult(5, 7, 6, 10, 8) // false
    printlnResult(5, 6, 10, 8, 7) // true
}

/**
 * Questions33-1: Input an array, judge whether the array is the post order of a binary search tree
 */
private fun <T : Comparable<T>> Array<T>.isPostOrder(): Boolean {
    if (isEmpty()) return false
    val mid = getMidIndex(0, lastIndex)
    return mid >= 0 && isPostOrder(0, lastIndex, mid)
}

private fun <T : Comparable<T>> Array<T>.isPostOrder(startIndex: Int, endIndex: Int, mid: Int): Boolean {
    if ((startIndex until mid).any { this[it] > this[endIndex] })
        return false
    if ((mid until endIndex).any { this[it] < this[endIndex] })
        return false
    return isSubArrayPostOrder(startIndex, mid - 1) && isSubArrayPostOrder(mid, endIndex - 1)
}

private fun <T : Comparable<T>> Array<T>.isSubArrayPostOrder(startIndex: Int, endIndex: Int): Boolean {
    if (startIndex == endIndex || endIndex - startIndex == 1)
        return true
    val mid = getMidIndex(startIndex, endIndex)
    return mid >= 0 && isPostOrder(startIndex, endIndex, mid)
}

private fun <T : Comparable<T>> Array<T>.getMidIndex(startIndex: Int, endIndex: Int): Int {
    val thisSize = endIndex - startIndex + 1
    val half = thisSize shr 1
    if (thisSize % 2 == 1)
        return half + startIndex
    val root = this[endIndex]
    return if (this[half] > root) {
        (if (this[half - 1] < root) half else half - 1) + startIndex
    } else -1
}

private fun printlnResult(vararg elements: Int) =
    println("Is the array: ${elements.toList()} post order of a binary search tree: ${elements.toTypedArray().isPostOrder()}")