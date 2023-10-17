package com.qiaoyuang.algorithm.round1

fun test56() {
    printlnResult1(intArrayOf(2, 4, 3, 6, 3, 2, 5, 5))
    printlnResult1(intArrayOf(1, 1, 2, 3))
    printlnResult1(intArrayOf(2, 3))

    printlnResult2(intArrayOf(1, 2, 1, 1))
    printlnResult2(intArrayOf(2, 3, 2, 1, 2, 3, 3))
    printlnResult2(intArrayOf(1))
}

/**
 * Questions 56-1: Find two numbers in an IntArray that only appear once, all other numbers appear twice
 */
private fun IntArray.findTwoNumberAppearOnce(): Pair<Int, Int> {
    require(size % 2 == 0) { "The IntArray is illegal" }
    var xorResult = first()
    for (i in 1..lastIndex)
        xorResult = xorResult xor this[i]
    val indexOf1 = xorResult.findFirstBitIs1()
    var num1 = 0
    var num2 = 0
    forEach {
        if (it isBit1 indexOf1)
            num1 = num1 xor it
        else
            num2 = num2 xor it
    }
    return num1 to num2
}

private fun Int.findFirstBitIs1(): Int {
    var indexBit = 0
    var num = this
    while (num and 1 == 0 && indexBit < 8 * Int.SIZE_BITS) {
        num = num shr 1
        indexBit++
    }
    return indexBit
}

private infix fun Int.isBit1(indexBit: Int): Boolean = this shr indexBit and 1 != 0

private fun printlnResult1(array: IntArray) =
    println("The two numbers just appear once are ${array.findTwoNumberAppearOnce()}, in array: ${array.toList()}")

/**
 * Questions 56-2: Find a number in an IntArray that only appear once, all other numbers appear thirds
 */
private fun IntArray.findNumberAppearOnce(): Int {
    require(isNotEmpty()) { "The IntArray is illegal" }
    val bitsSum = IntArray(32)
    forEach { num ->
        var bitMusk = 1
        for (j in 31 downTo 0) {
            val bit = num and bitMusk
            if (bit != 0)
                bitsSum[j] += 1
            bitMusk = bitMusk shl 1
        }
    }

    var result = 0
    repeat(32) {
        result = result shl 1
        result += bitsSum[it] % 3
    }
    return result
}

private fun printlnResult2(array: IntArray) =
    println("The two numbers just appear once are ${array.findNumberAppearOnce()}, in array: ${array.toList()}")
