package com.qiaoyuang.algorithm.round1

import kotlin.math.min

fun test51() {
    printlnResult(intArrayOf(7, 5, 6, 4))
    printlnResult(intArrayOf(7, 5, 6, 4, 1))
    printlnResult(intArrayOf(0, 7, 5, 6, 4, 1))
    printlnResult(intArrayOf(1))
}

/**
 * Questions 51: Find the count of reverse-order-pair in an IntArray
 */
private fun IntArray.getCountOfReverseOrderPair1(): Int {
    if (isEmpty()) return 0
    val aux = IntArray(size)
    var sz = 1
    var count = 0
    while (sz < size) {
        var start = 0
        while (start < size - sz) {
            count += merge(aux, start, start + sz - 1, min(start + sz + sz -1, size - 1))
            start += sz * 2
        }
        sz *= 2
    }
    return count
}

private fun IntArray.getCountOfReverseOrderPair2(): Int {
    val aux = IntArray(size)
    return mergeSort(aux, 0, lastIndex)
}

private fun IntArray.mergeSort(aux: IntArray, start: Int, end: Int): Int {
    if (start == end) {
        aux[start] = this[start]
        return 0
    }
    val mid = start + (end - start) / 2
    return mergeSort(aux, start, mid) + mergeSort(aux, mid + 1, end) + merge(aux, start, mid, end)
}

private fun IntArray.merge(aux: IntArray, start: Int, mid: Int, end: Int): Int {
    for (k in start..end)
        aux[k] = this[k]
    var count = 0
    var i = mid
    var j = end
    for (k in end downTo start) {
        when {
            i < start -> this[k] = aux[j--]
            j < mid + 1 -> this[k] = aux[i--]
            aux[i] > aux[j] -> {
                this[k] = aux[i--]
                count += j - mid
            }
            else -> this[k] = aux[j--]
        }
    }
    return count
}

private fun printlnResult(array: IntArray) {
    val list = array.toList()
    val arrayCopy = IntArray(array.size) { array[it] }
    println("There are: (${array.getCountOfReverseOrderPair1()}, ${arrayCopy.getCountOfReverseOrderPair2()}) reverse-order-pair in array $list")
}
