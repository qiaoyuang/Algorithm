package com.qiaoyuang.algorithm.special

import com.qiaoyuang.algorithm.round0.quickSort

fun test7() {
    printlnResult(intArrayOf(-1, 0, 1, 2, -1, -4))
    printlnResult(intArrayOf(-2, 0, -2, 1, -1, 2, 3, 4))
}

/**
 * Questions 7: Find all the three numbers in an IntArray that theirs sum is 0.
 */
private fun IntArray.findThreeNumbers(): List<Triple<Int, Int, Int>> {
    require(size > 2) { "The size of the IntArray must greater than 2" }
    quickSort()
    val array = this
    return buildList {
        var pointer0 = 0
        while (pointer0 <= array.lastIndex - 2) {
            var pointer1 = pointer0 + 1
            var pointer2 = array.lastIndex
            while (pointer1 < pointer2) {
                val sum = array[pointer0] + array[pointer1] + array[pointer2]
                when {
                    sum > 0 -> {
                        val current = array[pointer2--]
                        while (current == array[pointer2])
                            pointer2--
                    }
                    sum < 0 -> {
                        val current = array[pointer1++]
                        while (current == array[pointer1])
                            pointer1++
                    }
                    else -> {
                        add(Triple(array[pointer0], array[pointer1], array[pointer2]))
                        val current2 = array[pointer2--]
                        while (current2 == array[pointer2])
                            pointer2--
                        val current1 = array[pointer1++]
                        while (current1 == array[pointer1])
                            pointer1++
                    }
                }
            }
            val current = array[pointer0++]
            while (current == array[pointer0])
                pointer0++
        }
    }
}

private fun printlnResult(array: IntArray) {
    println("The all of the three numbers in IntArray: ${array.toList()} are:")
    println("(${array.findThreeNumbers()})")
    println("That theirs sum is 0.")
}
