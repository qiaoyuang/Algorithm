package com.qiaoyuang.algorithm.round1

import com.qiaoyuang.algorithm.round0.quickSort

fun test61() {
    printlnResult(intArrayOf(1, 2, 4, 5, 0)) // true
    printlnResult(intArrayOf(6, 13, 10, 9, 0, 8, 0, 12)) // true
    printlnResult(intArrayOf(2, 3 ,5, 0, 7, 10, 0)) // false
}

/**
 * Questions 61: Get 5 cards from a poke, judge if it is a straight
 */
private fun IntArray.isStraight(): Boolean {
    require(size in 5..13) { "" }
    quickSort()
    var count0 = 0
    var pointer = 0
    while (pointer < size) {
        if (this[pointer] == 0) {
            require(++count0 <= 2) { "Input error" }
        } else {
            val next = pointer + 1
            if (next < size) {
                when (this[next] - this[pointer]) {
                    0 -> return false
                    2 -> {
                        if (--count0 < 0)
                            return false
                    }
                    3 -> {
                        count0 -= 2
                        if (count0 < 0)
                            return false
                    }
                }
            }
        }
        pointer++
    }
    return true
}

private fun printlnResult(cards: IntArray) =
    println("Are the cards${cards.toList()} straight? ${cards.isStraight()}")