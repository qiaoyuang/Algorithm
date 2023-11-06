package com.qiaoyuang.algorithm.special

fun test16() {
    printlnResult("babcca")
    printlnResult("dcbafgadvzxcvbz")
}

/**
 * Questions 16: Find the longest substring that doesn't contain the repeated alphabets in a String
 */
private fun String.findLongestSubString(): String {
    if (isEmpty() || length == 1)
        return this
    val hashSet = HashSet<Char>()
    var start = 0
    var end = 1
    var substring = first().toString()
    hashSet.add(first())
    while (end < length) {
        val c = this[end]
        if (hashSet.contains(c)) {
            if (end - start + 1 > substring.length)
                substring = substring(start, end)
            hashSet.remove(this[start++])
        } else {
            hashSet.add(c)
            end++
        }
    }
    return substring
}

private fun printlnResult(str: String) =
    println("The longest substring in $str is ${str.findLongestSubString()}")