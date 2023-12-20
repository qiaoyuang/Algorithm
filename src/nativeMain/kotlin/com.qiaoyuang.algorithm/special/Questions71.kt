package com.qiaoyuang.algorithm.special

import platform.Foundation.NSDate
import platform.Foundation.now
import platform.Foundation.timeIntervalSince1970
import kotlin.random.Random

fun test71() {
    val intArray = intArrayOf(1, 2, 3, 4)
    val hashMap = HashMap<Int, Int>(intArray.size)
    repeat(10000) {
        val index = intArray.pickIndex()
        if (hashMap.containsKey(index)) {
            hashMap[index] = hashMap[index]!! + 1
        } else {
            hashMap[index] = 1
        }
    }
    hashMap.entries.forEach { (index, count) ->
        print("($index, ${count}) ")
    }
}

/**
 * Questions 71: Given an IntArray to represent weight, implement a
 * function that return the index by the probability.
 */
private fun IntArray.pickIndex(): Int {
    var sum = 0
    val sums = IntArray(size) {
        sum += this[it]
        sum
    }
    val random = Random((NSDate.now.timeIntervalSince1970 * 1000000).toLong())
    val p = random.nextInt(sum)
    var start = 0
    var end = lastIndex
    while (start < end) {
        val mid = (end + start) / 2
        when {
            sums[mid] > p -> {
                if (mid == 0 || sums[mid - 1] <= p)
                    return mid
                end = mid - 1
            }
            else -> start = mid + 1
        }
    }
    return start
}