package com.qiaoyuang.algorithm.special

fun test9() {
    printlnResult(intArrayOf(10, 5, 2, 6), 100)
}

/**
 * Questions 9: Given an IntArray and an integer k, find the count of all continues sub-array that product is less than k
 */
private infix fun IntArray.findCount(k: Int): Int {
    require(isNotEmpty()) { "The IntArray can't be empty" }
    var count = size
    repeat(size) { i ->
        var j = i + 1
        while (j < size) {
            val product = subProduct(i, j)
            if (product < k) {
                count++
                j++
            } else
                break
        }
    }
    return count
}

private fun IntArray.subProduct(i: Int, j: Int): Int {
    var product = 1
    for (index in i..j)
        product *= this[index]
    return product
}

private fun printlnResult(array: IntArray, k: Int) =
    println("The count of all continues sub-array that product less than $k is ${array findCount k} in array: ${array.toList()}")
