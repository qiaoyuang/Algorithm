package com.qiaoyuang.algorithm.special

fun test16() {
    printlnResult("babcca")
    printlnResult("dcbafgadvzxcvbz")
}

/**
 * Questions 16: Find the longest substring that doesn't contain the repeated alphabets in a String
 */
private fun findLongestSubstringLength(str: String): Int {
    if (str.isEmpty() || str.length == 1)
        return str.length
    val hashSet = HashSet<Char>() // Also could use the CharArray that's length is 256 (Ascii) to replace the HashSet
    var start = 0
    var end = 0
    var length = 1
    while (end < str.length) {
        val c = str[end]
        if (hashSet.contains(c)) {
            val newLength = end - start
            if (newLength > length)
                length = newLength
            hashSet.remove(str[start++])
        } else {
            hashSet.add(c)
            end++
        }
    }
    return length
}

private fun printlnResult(str: String) =
    println("The longest length of substring in $str is ${findLongestSubstringLength(str)}")