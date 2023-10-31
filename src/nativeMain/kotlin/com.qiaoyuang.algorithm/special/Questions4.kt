package com.qiaoyuang.algorithm.special

fun test4() {
    printlnResult(intArrayOf(1, 2, 1, 1))
    printlnResult(intArrayOf(2, 3, 2, 1, 2, 3, 3))
    printlnResult(intArrayOf(1))
    printlnResult(intArrayOf(1, 0, 1, 1, 100, 0, 0))
}

/**
 * Questions 4: Find a number in an IntArray that only appear once, all other numbers appear thirds
 */
private fun IntArray.findNumberAppearOnce(): Int {
    require(size % 3 == 1) { "The input IntArray is illegal" }
    val bitsSum = IntArray(32)
    forEach { num ->
        var bit = 1
        for (i in 31 downTo 0) {
            if (bit and num != 0)
                bitsSum[i]++
            bit = bit shl 1
        }
    }

    var result = 0
    repeat(32) {
        result = result shl 1
        result += bitsSum[it] % 3
    }
    return result
}

private fun printlnResult(array: IntArray) =
    println("The number just appear once is ${array.findNumberAppearOnce()} in array: ${array.toList()}")