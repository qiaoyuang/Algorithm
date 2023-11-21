package com.qiaoyuang.algorithm.special

fun test33() {
    printlnResult(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
}

/**
 * Questions 33: Give a string array, group strings as anagram
 */
private fun Array<String>.groupAsAnagram(): List<List<String>> {
    require(isNotEmpty()) { "The array can't be empty" }
    val result = ArrayList<MutableList<String>>()
    val hashArray = IntArray(size)
    var realSize = 0
    forEach {
        require(it.isNotEmpty()) { "The string can't be empty" }
        val hash = it.hash()
        println(hash)
        if (result.isEmpty()) {
            hashArray[realSize++] = hash
            result.add(mutableListOf(it))
        } else {
            var arrayIndex = 0
            var isFound = false
            while (hashArray[arrayIndex] > 0) {
                if (hashArray[arrayIndex] == hash) {
                    result[arrayIndex].add(it)
                    isFound = true
                    break
                } else
                    arrayIndex++
            }
            if (!isFound) {
                hashArray[realSize++] = hash
                result.add(mutableListOf(it))
            }
        }
    }
    return result
}

private val primeNumber = intArrayOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101)

private fun String.hash(): Int = fold(initial = 1) { acc, c -> acc * primeNumber[c.code - 97] }

private fun printlnResult(strings: Array<String>) =
    println("Group ${strings.toList()}, we got: ${strings.groupAsAnagram()}")