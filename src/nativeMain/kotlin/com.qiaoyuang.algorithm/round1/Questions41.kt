package com.qiaoyuang.algorithm.round1

import com.qiaoyuang.algorithm.round0.exchange

fun test41() {
    val sequence = sequence {
        repeat(80) {
            yield(it)
        }
    }
    printMedian(sequence)
}

private fun printMedian(sequence: Sequence<Int>) {
    val heapMax = IntArray(50)
    var maxIndex = 0
    val heapMin = IntArray(50)
    var minIndex = 0
    sequence.forEachIndexed { index, i ->
        val realIndex = index + 1
        val isAddMax = realIndex % 2 == 1
        if (isAddMax) {
            heapMax[++maxIndex] = i
            heapMax.swimMax(maxIndex)
        } else {
            heapMin[++minIndex] = i
            heapMin.swimMin(minIndex)
        }
        if (maxIndex > 0 && minIndex > 0 && heapMax[1] > heapMin[1]) {
            val temp = heapMax[1]
            heapMax[1] = heapMin[1]
            heapMin[1] = temp
        }
        printlnMedian(heapMax, heapMin, maxIndex, minIndex)
    }
}

private fun IntArray.swimMax(i: Int) {
    var k = i
    while (k > 1 && this[k / 2] < this[k]) {
        exchange(k / 2, k)
        k /= 2
    }
}

private fun IntArray.swimMin(i: Int) {
    var k = i
    while (k > 1 && this[k / 2] > this[k]) {
        exchange(k / 2, k)
        k /= 2
    }
}

private fun printlnMedian(heapMax: IntArray, heapMin: IntArray, heapMaxRealIndex: Int, heapMinRealIndex: Int) {
    val elements = buildList {
        if (heapMaxRealIndex > 0)
            for (i in 1..heapMaxRealIndex)
                add(heapMax[i])
        if (heapMinRealIndex > 0)
            for (i in 1..heapMinRealIndex)
                add(heapMin[i])
    }
    val median = when {
        heapMaxRealIndex > heapMinRealIndex -> heapMax[1]
        heapMaxRealIndex < heapMinRealIndex -> heapMin[1]
        else -> (heapMax[1] + heapMin[1]) / 2
    }
    println("The median of sequence: $elements is: $median")
}
