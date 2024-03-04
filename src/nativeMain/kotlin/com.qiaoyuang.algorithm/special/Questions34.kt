package com.qiaoyuang.algorithm.special

import kotlin.math.min

fun test34() {
    printlnResult(arrayOf("offer", "is", "coming"), "abcdefghijklmnopqrstuvwxyz".reversed())
}

/**
 * Questions 34: Judge if a group of words is sorted by a new alphabet
 */
private infix fun Array<String>.isSorted(alphabet: String): Boolean {
    require(isNotEmpty()) { "The array can't be empty" }
    require(alphabet.length == 26) { "The alphabet is illegal" }
    if (size == 1)
        return true
    val alphabetMap = IntArray(26)
    alphabet.forEachIndexed { i, c ->
        alphabetMap[c.code - 'a'.code] = i
    }
    var index = 1
    while (index < size) {
        val word = this[index]
        val preWord = this[index - 1]
        if (!isBefore(preWord, word, alphabetMap)) {
            return false
        }
        index++
    }
    return true
}

private fun isBefore(a: String, b: String, alphabetMap: IntArray): Boolean {
    var index = 0
    val shortLength = min(a.length, b.length)
    while (index < shortLength) {
        val ca = a[index]
        val cb = b[index]
        when {
            alphabetMap[ca.code - 'a'.code] < alphabetMap[cb.code - 'a'.code] -> return true
            alphabetMap[ca.code - 'a'.code] > alphabetMap[cb.code - 'a'.code] -> return false
            else -> index++
        }
    }
    return a.length <= b.length
}

private fun printlnResult(words: Array<String>, alphabet: String) =
    println("Is statement ${words.toList()} arranged by alphabet $alphabet: ${words isSorted alphabet}")