package com.qiaoyuang.algorithm.special

fun test75() {
    printlnResult(
        array = intArrayOf(2, 3, 3, 7, 3, 9, 2, 1, 7, 2),
        comparator = intArrayOf(3, 2, 1),
    )
}

/**
 * Questions 75:
 */
private fun sortArrayWithOther(array: IntArray, comparator: IntArray): IntArray {
    val comparatorMap = buildMap {
        comparator.forEachIndexed { index, num ->
            this[num] = index
        }
    }
    array.sortedWith { a, b ->
        val indexA = comparatorMap[a]
        val indexB = comparatorMap[b]
        when {
            indexA == null && indexB != null -> 1
            indexA != null && indexB == null -> -1
            indexA == null && indexB == null -> a - b
            else -> indexA!!- indexB!!
        }
    }.forEachIndexed { index, i ->
        array[index] = i
    }
    return array
}

private fun printlnResult(array: IntArray, comparator: IntArray) {
    println("Given an IntArray: ${array.toList()},")
    println("sorted it by ${comparator.toList()},")
    println("we can get: ${sortArrayWithOther(array, comparator).toList()}")
}