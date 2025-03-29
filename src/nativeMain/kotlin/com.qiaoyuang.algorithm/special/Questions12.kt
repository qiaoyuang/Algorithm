package com.qiaoyuang.algorithm.special

fun test12() {
    printlnResult(intArrayOf(1, 7, 3, 6, 2, 9))
    printlnResult(intArrayOf(0, 0, 0))
    printlnResult(intArrayOf(8))
    printlnResult(intArrayOf(6, 2, 9, 1, 7, 3, 5, 2))
}

/**
 * Find Pivot Index, LeetCode 724
 */
private fun IntArray.findIndex(): Int {
    if (size < 3)
        return -1
    var sumLeft = 0
    var sumRight = sum() - first()
    for (i in 1 ..< lastIndex) {
        sumLeft += this[i - 1]
        sumRight -= this[i]
        if (sumLeft == sumRight)
            return i
    }
    return -1
}

private fun printlnResult(array: IntArray) =
    println("The index that legal is ${array.findIndex()} in array: ${array.toList()}")