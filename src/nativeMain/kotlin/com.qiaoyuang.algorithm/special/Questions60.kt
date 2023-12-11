package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.PriorityQueue

fun test60() {
    printlnResult(intArrayOf(1, 2, 2, 1, 3, 1), 2)
}

/**
 * Questions 60: The k numbers that highest appearance frequency
 */
private fun IntArray.highestAppearanceFrequency(k: Int): IntArray {
    val hashMap = HashMap<Int, SpecialEntry>()
    forEach {
        if (hashMap.containsKey(it))
            hashMap[it]!!.frequency++
        else
            hashMap[it] = SpecialEntry(it)
    }
    val priorityQueue = PriorityQueue<SpecialEntry>()
    hashMap.forEach { (_, entry) ->
        priorityQueue.enqueue(entry)
    }
    return IntArray(k) {
        val num = priorityQueue.peak
        priorityQueue.dequeue()
        num.number
    }
}

private class SpecialEntry(
    val number: Int,
): Comparable<SpecialEntry> {

    var frequency = 1
    override fun compareTo(other: SpecialEntry): Int = frequency - other.frequency
}

private fun printlnResult(nums: IntArray, k: Int) =
    println("The k numbers that highest appearance frequency in ${nums.toList()} are ${nums.highestAppearanceFrequency(k).toList()}")