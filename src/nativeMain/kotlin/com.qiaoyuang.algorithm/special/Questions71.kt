package com.qiaoyuang.algorithm.special

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
 * Questions 71: Random Pick with Weight, LeetCode 528
 */
private fun IntArray.pickIndex(): Int {
    var sum = 0
    val sums = IntArray(size) {
        sum += this[it]
        sum
    }
    val p = Random.nextInt(sum)
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