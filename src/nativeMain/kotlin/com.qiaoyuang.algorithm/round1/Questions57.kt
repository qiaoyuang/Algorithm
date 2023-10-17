package com.qiaoyuang.algorithm.round1

fun test57() {
    printlnResult1(intArrayOf(1, 2, 4, 7, 11, 15), 15)
    printlnResult1(intArrayOf(0, 1, 2, 4, 7, 11, 15), 15)
    printlnResult2(15)
    printlnResult2(1)
    printlnResult2(6)
    printlnResult2(9)
    printlnResult2(10)
    printlnResult2(12)
}

/**
 * Questions 57-1: Find the two numbers in an increment IntArray that their sum is s
 */
private infix fun IntArray.findTwoNumbers(s: Int): Pair<Int, Int> {
    var pointer1 = 0
    var pointer2 = lastIndex
    while (pointer1 != pointer2)
        when {
            this[pointer1] + this[pointer2] > s -> pointer2--
            this[pointer1] + this[pointer2] < s -> pointer1++
            else -> return this[pointer1] to this[pointer2]
        }
    throw IllegalArgumentException("This IntArray doesn't have two numbers that sum is $s")
}

private fun printlnResult1(array: IntArray, s: Int) =
    println("The two numbers are ${array.findTwoNumbers(s)} in IntArray: ${array.toList()} that their sum is $s")

/**
 * Questions 57-2: Input an integer, find the all continuous positive integer sequence that each sum equals this integer
 */
private fun Int.findSequences(): List<IntRange> {
    require(this > 0) { "The integer must greater than 0" }
    var small = 1
    var big = 2
    val max = (1 + this) shr 1
    return buildList {
        while (big <= max && big != small) {
            val range = small..big
            val sum = range.sum()
            when {
                sum < this@findSequences -> big++
                sum > this@findSequences -> small++
                else -> {
                    add(range)
                    big++
                }
            }
        }
    }
}

private fun printlnResult2(num: Int) {
    println("The all continuous positive integer sequences that sum equals $num is:")
    num.findSequences().forEach {
        println(it.toList())
    }
}