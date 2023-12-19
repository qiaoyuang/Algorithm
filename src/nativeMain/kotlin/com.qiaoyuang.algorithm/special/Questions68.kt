package com.qiaoyuang.algorithm.special

fun test68() {
    printlnResult(3, 1, 3, 6, 8)
    printlnResult(5, 1, 3, 6, 8)
}

/**
 * Questions 68: Find the index of a number in an IntArray, if this number doesn't exit in this IntArray,
 * return the index of this number after we insert it to the IntArray.
 */
private infix fun IntArray.findIndex(num: Int): Int {
    var start = 0
    var end = lastIndex
    var mid = (end - start) / 2 + start
    while (start != mid && end != mid) {
        when {
            this[mid] > num -> {
                end = mid
                mid = (end - start) / 2 + start
            }
            this[mid] < num -> {
                start = mid + 1
                mid = (end - start) / 2 + start
            }
            else -> return mid
        }
    }
    return if (num > this[start]) start + 1 else start
}

private fun printlnResult(t: Int, vararg nums: Int) =
    println("The index of $t in IntArray ${nums.toList()} is ${nums findIndex t}")