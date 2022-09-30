package com.qiaoyuang.algorithm

fun test3() {
    val array1 = intArrayOf(2, 3, 1, 0, 2, 5, 3)
    println("数组 1 重复的数字是：${array1.findRepeat1()}")
    val array2 = intArrayOf(2, 3, 5, 4, 3, 2, 6, 7)
    println("数组 2 重复的数字是：${array2.findRepeat2()}")
}

/**
 * 题目一：寻找数组中重复的数字，数组长度 n，数字都在 0 ～ n-1 的范围内
 */
fun IntArray.findRepeat1(): Int {
    shellSort()
    forEachIndexed { index, i ->
        if (index != i)
            if (i == this[i]) return i else exchange(index, i)
    }
    throw IllegalArgumentException("该数组没有重复数字")
}

/**
 * 题目二：同题目一，但不能修改数组，且数组长度 n + 1，数字在 1 ～ n 范围内；
 * find2 函数使用二分查找，时间复杂度 O(nlogn)，空间复杂度 O(1)，
 * 也可以使用辅助数组，时间复杂度 O(n)，空间复杂度 O(n)，这个解法比较简单，这里不给出。
 */
fun IntArray.findRepeat2(): Int = findRepeat2(1, size / 2, size - 1)

private tailrec fun IntArray.findRepeat2(start: Int, mid: Int, end: Int): Int {
    require(start <= end) { "该数组没有重复数字" }
    val count = countArrayInRange(start..mid)
    return when {
        start == end -> if (count > 1) start else throw IllegalArgumentException("该数组没有重复数字")
        count > mid - start + 1 -> findRepeat2(start, (mid - start) / 2 + start, mid)
        else -> {
            val newStart = mid + 1
            findRepeat2(newStart, (end - newStart) / 2 + newStart, end)
        }
    }
}

private fun IntArray.countArrayInRange(range: IntRange): Int =
    countArrayInRange(range, 0, 0)

private tailrec fun IntArray.countArrayInRange(range: IntRange, index: Int, count: Int): Int =
    if (index in indices)
        countArrayInRange(range, index + 1,
            if (this[index] in range) count + 1 else count)
    else count