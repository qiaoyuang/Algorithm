package com.qiaoyuang.algorithm.round1

import kotlin.math.min

fun test48() {
    println("arbabcacfr".findLongestSubstring())
    println("bcadebasevdbaed".findLongestSubstring())
}

/**
 * Questions 48: If a string just contain a~z, find the longest sub-string that doesn't contain the repeat character in the string
 */
private fun String.findLongestSubstring(): String {
    val set = HashSet<Char>(min(26, length))
    var longestStr = ""
    var currentStr = ""
    for (i in 0..lastIndex) {
        val c = get(i)
        if (set.contains(c)) {
            set.clear()
            set.add(c)
            if (currentStr.length > longestStr.length) {
                longestStr = currentStr
            }
            currentStr = c.toString()
        } else {
            currentStr += c
            set.add(c)
        }
    }
    if (currentStr.length > longestStr.length) {
        longestStr = currentStr
    }
    return longestStr
}