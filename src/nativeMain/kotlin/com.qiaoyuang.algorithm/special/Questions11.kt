package com.qiaoyuang.algorithm.special

fun test11() {
    printlnResult(intArrayOf(1, 0, 1))
    printlnResult(intArrayOf(1, 1, 0, 1))
    printlnResult(intArrayOf(1, 1, 0, 1, 0, 0, 1))
}

/**
 * Questions 11: Find the counts of consistent sub-arrays that their counts of
 * 1 and 0 equal in an IntArray that just contain 0 and 1, and the sub-arrays
 * contain 2 elements at least.
 */

private fun IntArray.findCountOf0and1(): Int {
    require(size > 2) { "The size of IntArray must greater than 2" }
    var count = 0
    val aux = IntArray(size)
    for (subSize in 2 ..< size) {
        var i = 0
        var j = i + subSize - 1
        while (j < size)
            aux[subSum(i++ ,j++)]++
        count += aux.foldIndexed(0) { index, acc, singleCount ->
            when (singleCount) {
                0 -> acc
                1 -> {
                    aux[index] = 0
                    acc
                }
                else -> {
                    aux[index] = 0
                    acc + singleCount
                }
            }
        }
    }
    return count
}

private fun IntArray.subSum(i: Int, j: Int): Int {
    var sum = 0
    for (index in i..j)
        sum += this[index]
    return sum
}

private fun printlnResult(array: IntArray) =
    println("The count of consistent sub-arrays that counts of 0 and 1 equal is (${array.findCountOf0and1()}) in array: ${array.toList()}")
